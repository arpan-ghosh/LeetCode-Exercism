
prompt 'Problem #1 ';

#solution
SELECT dorm_name AS Dorm
FROM Dorm
WHERE gender = "M"
;

prompt 'Problem #2 ';

#solution
SELECT S.Fname AS First, S.LName AS Last, D.DName AS Major
FROM Department AS D, Enrolled_in AS E, Student AS S
WHERE D.DNO = S.Major
AND E.StuID = S.StuID
AND E.CID = 
(SELECT CID
FROM Course
WHERE Instructor = (SELECT FacID
FROM Faculty
WHERE Fname = 'Russell' AND Lname = 'Taylor'))
;



prompt 'Problem #3 ';

#solution
SELECT S.Fname AS First, S.LName AS Last, S.Age, S.Sex
FROM Student AS S
WHERE StuID IN 
(SELECT StuID FROM 
	(SELECT Room_number, StuID, dormID
	FROM Lives_in
	GROUP BY Room_number, dormID
	HAVING COUNT(*) = 1) AS X
)
;




prompt 'Problem #4 ';

#solution
SELECT S.FName AS First, S.Lname AS Last, D.Dname AS Major
FROM Student AS S, Department AS D
WHERE S.Major = D.DNO
AND S.StuID NOT IN 
(SELECT StuID
FROM Enrolled_in
WHERE CID IN 
(SELECT CID
FROM Course AS C
WHERE C.DNO = S.Major
) 
) 
;



prompt 'Problem #5 ';

#solution
SELECT A.Activity_name AS Activity
FROM
Activity AS A
WHERE A.ActID = 
(SELECT P.ActID
FROM Faculty_Participates_in AS P
GROUP BY P.ActID
ORDER BY COUNT(*) DESC
LIMIT 1)
;




prompt 'Problem #6 ';

#solution
SELECT A.Activity_name AS Activity, COUNT(*) as Participants
FROM
Participates_in AS P, Activity AS A
WHERE P.ActID = A.ActID
GROUP BY P.ActID
HAVING Participants >= 3
ORDER BY Participants DESC, Activity_name ASC
;



prompt 'Problem #7 ';

#solution
SELECT S.Fname AS First, S.LName AS Last, D.Dname AS Major
FROM
Student AS S, Department AS D
WHERE S.Major = D.DNO
AND S.StuID IN
(SELECT P.StuID
FROM Participates_in AS P
GROUP BY P.StuID
HAVING COUNT(*) >= 2
)
AND S.StuID IN
(SELECT Pa.StuID
FROM Participates_in as Pa
WHERE Pa.ActID = 
(SELECT ActID
FROM Activity AS A
WHERE A.Activity_name = 'Baseball'))
;



prompt 'Problem #8 ';

#solution
SELECT DISTINCT S.Fname, S.Lname, D.Dname
FROM Student AS S, Department AS D, Enrolled_in AS E
WHERE S.StuID IN 
(SELECT StuID 
FROM Participates_in AS P
GROUP BY StuID
HAVING COUNT(*) >= 2)
AND S.StuID NOT IN 
(SELECT StuID
FROM Enrolled_in AS E
WHERE E.Grade >= 'C')
AND S.Major = D.DNO
AND E.StuID = S.StuID
;



prompt 'Problem #9 ';

#solution
SELECT S.Fname AS First, S.LName as Last, D.Dname AS Major
FROM
(SELECT P.StuID
FROM Participates_in AS P
GROUP BY P.StuID) AS A, Department AS D, Student AS S
WHERE S.Major = D.DNO
AND S.StuID = A.StuID
AND S.StuID IN
(SELECT whoIsLoved
FROM
(SELECT MAX(number) AS mostLoved, WhoIsLoved
FROM 
(SELECT COUNT(whoIsLoved) as number, whoIsLoved
FROM Loves
GROUP BY whoIsLoved
ORDER BY number DESC) AS X
) AS Y
)
;






prompt 'Problem #10 ';

#solution
SELECT F.Fname AS First, F.Lname AS Last, D.Dname AS Department, F.Building AS office_Building, D.Building AS department_Building
FROM
Faculty AS F, Department AS D, Member_of AS M
WHERE M.DNO = D.DNO
AND M.FacID = F.FacID
AND F.Building <> D.Building
;



prompt 'Problem #11 ';

#solution
SELECT D.Dname AS Department, num AS Courses
FROM 
(SELECT DNO, COUNT(teach) AS num
FROM 
(SELECT C.DNO, C.Instructor, COUNT(DISTINCT CID) AS teach
FROM Member_of AS M, Course AS C
WHERE M.FacID = C.Instructor
AND M.Appt_Type = 'Primary'
GROUP BY Instructor
) as per
GROUP BY DNO
) as c, Department AS D
WHERE D.DNO = c.DNO
ORDER BY Courses
;


prompt 'Problem #12 ';

#solution
SELECT D.dorm_name AS Dorm, D.Student_capacity AS Capacity
FROM Dorm as D
WHERE D.gender = 'F'
AND D.dormid NOT IN
(SELECT dormid
FROM Has_amenity as H)
;


prompt 'Problem #13 ';

#solution
SELECT D.dormid AS Dorm, D.student_capacity AS Capacity
FROM (
SELECT dormid, Count(amenid) 
FROM Has_amenity 
GROUP BY dormid 
HAVING Count(amenid) >= ALL (
SELECT Count(amenid) 
FROM Has_amenity 
GROUP BY dormid)
) as X, Dorm as D
WHERE D.dormid = X.dormid
; 

prompt 'Problem #14 ';

#solution
SELECT S.Fname AS First, S.LName AS Last, D.Dname AS Major, F.Fname AS advisor_First, F.Lname AS advisor_Last
FROM Faculty AS F, Department AS D, Student AS S
WHERE S.Major = D.DNO
AND S.Advisor = F.FacID
AND S.StuID IN
(SELECT E.StuID
FROM Course AS C, Enrolled_in AS E
WHERE C.CID = E.CID
AND C.Cname = 'Computer Vision'
AND E.Grade = 'A+')
;




prompt 'Problem #15 ';

#solution
SELECT C.Cname AS courseName, C.CID, S.Fname AS First, S.Lname AS Last, D.Dname AS Major, F.Fname AS advisor_First, F.Lname AS advisor_Last
FROM Student AS S, Course AS C, Department AS D, Faculty AS F
WHERE D.DNO = S.Major
AND F.FacID = S.Advisor
AND S.StuID IN
(SELECT E.StuID
FROM Enrolled_in AS E
WHERE E.CID = C.CID
GROUP BY E.CID
HAVING MIN(Grade))
;







prompt 'Problem #16 ';

#solution
SELECT num AS Average_age
FROM 
(SELECT AVG(age) AS num
FROM
Student AS S
WHERE S.StuID NOT IN
(SELECT StuID
FROM Participates_in AS P
GROUP BY StuID) 
) as X
;



prompt 'Problem #17 ';

#solution
SELECT S.Fname AS First, S.Lname AS Last, D.Dname AS Major, F.Fname as advisor_First, F.Lname AS advisor_Last
FROM Student AS S, Department AS D, Faculty AS F
WHERE S.Advisor = F.FacID
AND S.Major = D.DNO
AND S.City_Code IN
(SELECT S.City_Code
FROM
Student AS S2, Direct_distance AS DD, City AS C
WHERE
C.City_name = 'Baltimore'
AND C.State = 'MD'
AND DD.City1_code = C.city_code
AND DD.City2_code = S2.city_code
AND DD.Distance >= ALL
(SELECT Dist.distance
FROM Direct_distance as Dist, Student AS S3, City AS C2
WHERE Dist.city1_code = C2.city_code
AND Dist.city2_code = S3.city_code
AND C2.City_name = 'Baltimore'
AND C2.State = 'MD'
)
)
;





prompt 'Problem #20 ';

#solution
SELECT S.Fname AS First, S.Lname AS Last
FROM Student AS S
WHERE S.StuID IN
(SELECT P.StuID
FROM Preferences AS P
WHERE P.Smoking = 'Yes')
AND S.StuID IN
(SELECT L.StuID
FROM Has_amenity AS H, Lives_in AS L, Dorm_amenity AS D
WHERE H.dormid = L.dormID
AND D.amenity_name = 'Working Fireplaces'
AND D.amenID = H.amenID)
ORDER BY S.Lname
;



prompt 'Problem #24 ';

#solution
SELECT S.FName AS First, S.LName AS Last
FROM Student AS S
WHERE S.StuID IN
(SELECT H.StuID
FROM Has_Allergy AS H
WHERE Allergy IN
(SELECT Allergy
FROM Allergy_Type AS A
WHERE A.AllergyType = 'Environmental')
)
AND S.StuID IN
(SELECT L.whoIsLoved
FROM Loves AS L
GROUP BY L.whoIsLoved
HAVING COUNT(*) > 0)
ORDER BY S.Lname
;


prompt 'Problem #25 ';

#solution
SELECT C.Cname AS CourseName, C.CID
FROM Course AS C
WHERE C.CID IN
(SELECT E.CID
FROM Enrolled_in AS E
WHERE E.StuID IN 
(SELECT L.StuID
FROM Lives_in AS L
WHERE L.DormID = 
(SELECT D.DormID
FROM Dorm AS D
WHERE D.Dorm_name = 'Bud Jones Hall'
)
)
GROUP BY E.CID
)
LIMIT 1
;

prompt 'Problem #29 ';

#solution
SELECT DISTINCT X.Allergy, A.AllergyType
FROM
(SELECT H.Allergy
FROM Has_Allergy AS H
WHERE H.StuID IN 
(SELECT S.StuID
FROM Student AS S
WHERE S.Age > 25
)
GROUP BY H.Allergy
HAVING COUNT(*) >= ALL
(SELECT COUNT(*)
FROM Has_Allergy AS H
GROUP BY H.Allergy)
) AS X, Allergy_Type AS A
WHERE A.AllergyType IN 
(SELECT A.AllergyType
FROM Allergy_Type AS A
WHERE A.Allergy = X.Allergy)

;


prompt 'Problem #32 ';

#solution
SELECT D.Dname AS Major, D.DNO AS DepartmentNumber
FROM Department AS D
WHERE D.DNO IN 
(SELECT S.Major
FROM Student AS S
GROUP BY S.Major
HAVING COUNT(*) <= 3
)
AND D.DNO IN
(SELECT D.DNO
FROM 

;

prompt 'Problem #34 ';

#solution
SELECT DISTINCT S.Fname AS First, S.Lname AS Last
FROM Student AS S, Has_Allergy AS H
WHERE S.StuID IN
(SELECT H.StuID
FROM Has_Allergy AS H
WHERE Allergy IN
(SELECT Allergy
FROM Allergy_Type AS A
WHERE A.AllergyType = 'Environmental')
)
AND S.StuID IN
(SELECT P.StuID
FROM Preferences AS P
WHERE P.Smoking = 'YES')
ORDER BY S.Lname
;


prompt 'Problem #35 ';

#solution
SELECT S.FName AS First, S.Lname AS Last, S.Age AS Age, D.Dname AS Major, F.Fname AS advisor_First, F.Lname AS advisor_Last
FROM Student AS S, Department AS D, Faculty AS F
WHERE D.DNO = S.Major
AND F.FacID = S.Advisor
AND S.StuID IN
(SELECT E.StuID
FROM Enrolled_in AS E
WHERE E.CID IN
(SELECT C.CID
FROM Course AS C
WHERE C.Instructor = S.Advisor)
)
;




prompt 'Problem #36 ';

#solution
SELECT D.Division, COUNT(E.StuID) AS Enrolled
FROM Department AS D, Course AS C, Enrolled_in AS E
WHERE C.CID = E.CID
AND C.DNO = D.DNO
GROUP BY Division
;




prompt 'Problem #44 ';

#solution
SELECT COUNT(S.StuID) AS number_Of_People
FROM Preferences AS P, Student AS S
WHERE P.StuID = S.StuID
AND P.Smoking = 'Yes'
AND S.StuID NOT IN
(SELECT whoLikes
FROM Likes)
AND S.Major = 
(SELECT DNO
FROM Department AS D
WHERE D.Dname = 'Computer Science')
;


prompt 'Problem #45 ';

#solution
SELECT F.Fname AS First, F.Lname AS Last, F.Building AS Building
FROM Member_of AS M, Faculty AS F
WHERE M.Appt_Type = 'Secondary'
AND F.FacID = M.FacID
AND M.DNO = 
(SELECT D.DNO
FROM Department AS D
WHERE D.Dname = 'Computer Science')
AND F.Building <> 'NEB'
;



prompt 'Problem #48 ';

#solution
SELECT C.CID, C.Cname AS Course_Name, C.Credits , E.Grade AS LetGrade, G.Gradepoint
FROM Course AS C, Enrolled_in AS E, Gradeconversion AS G
WHERE E.StuID IN
(SELECT S.StuID
FROM Student AS S
WHERE S.Fname = 'Bruce' AND S.Lname = 'Wilson')
AND C.CID = E.CID
AND G.lettergrade = E.grade
;


prompt 'Problem #49 ';

#solution
SELECT E.StuID, SUM(C.Credits) AS Credits, SUM(G.gradepoint * C.Credits)/SUM(C.Credits) AS GPA
FROM Enrolled_in AS E, Student AS S, Course AS C, Gradeconversion AS G
WHERE S.Major = C.DNO
AND S.StuID = E.StuID
AND E.CID = C.CID
AND E.Grade = G.lettergrade
AND S.Fname = 'Bruce'
AND S.Lname = 'Wilson'
;


prompt 'Problem #50 ';

#solution
SELECT S.Fname AS First, S.Lname AS Last, ROUND(SUM(G.gradepoint * C.Credits)/SUM(C.Credits), 1) AS GPA
FROM Enrolled_in AS E, Gradeconversion AS G, Course AS C, Student AS S
WHERE E.StuID = S.StuID
AND E.Grade = G.lettergrade
AND E.CID = C.CID
AND S.Major = C.DNO
GROUP BY S.StuID
;










