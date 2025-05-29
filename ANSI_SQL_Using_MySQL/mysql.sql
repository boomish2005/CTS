-- 1
SELECT u.user_id,u.full_name,e.event_id,e.title,e.city,e.start_date
FROM Users u
JOIN Registrations r ON u.user_id=r.user_id
JOIN Events e ON r.event_id=e.event_id
WHERE e.status='upcoming' AND e.city=u.city
ORDER BY e.start_date;
-- 2
SELECT e.event_id,e.title,AVG(f.rating) AS avg_rating
FROM Events e
JOIN Feedback f ON e.event_id=f.event_id
GROUP BY e.event_id,e.title
HAVING COUNT(f.feedback_id)>=10
ORDER BY avg_rating DESC;
-- 3
SELECT u.user_id,u.full_name,u.email
FROM Users u
LEFT JOIN Registrations r ON u.user_id=r.user_id AND r.registration_date>=DATE_SUB(CURDATE(),INTERVAL 90 DAY)
WHERE r.registration_id IS NULL;
-- 4
SELECT e.event_id,e.title,COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id=s.event_id
WHERE s.start_time IS NULL OR (HOUR(s.start_time)>=10 AND HOUR(s.start_time)<12)
GROUP BY e.event_id,e.title;
-- 5
SELECT u.city,COUNT(DISTINCT r.user_id) AS user_count
FROM Users u
JOIN Registrations r ON u.user_id=r.user_id
GROUP BY u.city
ORDER BY user_count DESC
LIMIT 5;
-- 6
SELECT e.event_id,e.title,
SUM(CASE WHEN r.resource_type='pdf' THEN 1 ELSE 0 END) AS pdf_count,
SUM(CASE WHEN r.resource_type='image' THEN 1 ELSE 0 END) AS image_count,
SUM(CASE WHEN r.resource_type='link' THEN 1 ELSE 0 END) AS link_count
FROM Events e
LEFT JOIN Resources r ON e.event_id=r.event_id
GROUP BY e.event_id,e.title;
-- 7
SELECT u.user_id,u.full_name,e.title,f.rating,f.comments
FROM Users u
JOIN Feedback f ON u.user_id=f.user_id
JOIN Events e ON f.event_id=e.event_id
WHERE f.rating<3;
-- 8
SELECT e.event_id,e.title,COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id=s.event_id
WHERE e.status='upcoming'
GROUP BY e.event_id,e.title;
-- 9
SELECT u.user_id,u.full_name,
SUM(CASE WHEN e.status='upcoming' THEN 1 ELSE 0 END) AS upcoming_count,
SUM(CASE WHEN e.status='completed' THEN 1 ELSE 0 END) AS completed_count,
SUM(CASE WHEN e.status='cancelled' THEN 1 ELSE 0 END) AS cancelled_count
FROM Users u
LEFT JOIN Events e ON u.user_id=e.organizer_id
GROUP BY u.user_id,u.full_name;
-- 10
SELECT e.event_id,e.title
FROM Events e
JOIN Registrations r ON e.event_id=r.event_id
LEFT JOIN Feedback f ON e.event_id=f.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.event_id,e.title;
-- 11
SELECT registration_date,COUNT(*) AS user_count
FROM Users
WHERE registration_date>=DATE_SUB(CURDATE(),INTERVAL 7 DAY)
GROUP BY registration_date
ORDER BY registration_date;
-- 12
SELECT e.event_id,e.title,COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id=s.event_id
GROUP BY e.event_id,e.title
HAVING session_count=(SELECT MAX(session_count) FROM (SELECT COUNT(session_id) AS session_count FROM Sessions GROUP BY event_id) AS max_sessions);
-- 13
SELECT e.city,AVG(f.rating) AS avg_rating
FROM Events e
JOIN Feedback f ON e.event_id=f.event_id
GROUP BY e.city;
-- 14
SELECT e.event_id,e.title,COUNT(r.registration_id) AS registration_count
FROM Events e
JOIN Registrations r ON e.event_id=r.event_id
GROUP BY e.event_id,e.title
ORDER BY registration_count DESC
LIMIT 3;
-- 15
SELECT s1.event_id,e.title,s1.session_id AS session1_id,s1.title AS session1_title,
s2.session_id AS session2_id,s2.title AS session2_title
FROM Sessions s1
JOIN Sessions s2 ON s1.event_id=s2.event_id AND s1.session_id<s2.session_id
JOIN Events e ON s1.event_id=e.event_id
WHERE s1.start_time<s2.end_time AND s2.start_time<s1.end_time;
-- 16
SELECT u.user_id,u.full_name,u.email
FROM Users u
LEFT JOIN Registrations r ON u.user_id=r.user_id
WHERE u.registration_date>=DATE_SUB(CURDATE(),INTERVAL 30 DAY)
AND r.registration_id IS NULL;
-- 17
SELECT speaker_name,COUNT(session_id) AS session_count
FROM Sessions
GROUP BY speaker_name
HAVING session_count>1;
-- 18
SELECT e.event_id,e.title
FROM Events e
LEFT JOIN Resources r ON e.event_id=r.event_id
WHERE r.resource_id IS NULL;
-- 19
SELECT e.event_id,e.title,COUNT(r.registration_id) AS registration_count,
AVG(f.rating) AS avg_rating
FROM Events e
LEFT JOIN Registrations r ON e.event_id=r.event_id
LEFT JOIN Feedback f ON e.event_id=f.event_id
WHERE e.status='completed'
GROUP BY e.event_id,e.title;
-- 20
SELECT u.user_id,u.full_name,
COUNT(DISTINCT r.event_id) AS events_attended,
COUNT(f.feedback_id) AS feedbacks_submitted
FROM Users u
LEFT JOIN Registrations r ON u.user_id=r.user_id
LEFT JOIN Feedback f ON u.user_id=f.user_id
GROUP BY u.user_id,u.full_name;
-- 21
SELECT u.user_id,u.full_name,COUNT(f.feedback_id) AS feedback_count
FROM Users u
JOIN Feedback f ON u.user_id=f.user_id
GROUP BY u.user_id,u.full_name
ORDER BY feedback_count DESC
LIMIT 5;
-- 22
SELECT r.user_id,u.full_name,r.event_id,e.title,COUNT(*) AS registration_count
FROM Registrations r
JOIN Users u ON r.user_id=u.user_id
JOIN Events e ON r.event_id=e.event_id
GROUP BY r.user_id,r.event_id,u.full_name,e.title
HAVING registration_count>1;
-- 23
SELECT DATE_FORMAT(registration_date,'%Y-%m') AS month,COUNT(*) AS registration_count
FROM Registrations
WHERE registration_date>=DATE_SUB(CURDATE(),INTERVAL 12 MONTH)
GROUP BY month
ORDER BY month;
-- 24
SELECT e.event_id,e.title,
AVG(TIMESTAMPDIFF(MINUTE,s.start_time,s.end_time)) AS avg_duration_minutes
FROM Events e
LEFT JOIN Sessions s ON e.event_id=s.event_id
GROUP BY e.event_id,e.title;
-- 25
SELECT e.event_id,e.title
FROM Events e
LEFT JOIN Sessions s ON e.event_id=s.event_id
WHERE s.session_id IS NULL;
