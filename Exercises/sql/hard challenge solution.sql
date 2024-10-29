-- This is the final solution: see thought process below to get here
SELECT 
	c.FirstName || ' ' || c.LastName AS Customer,
	a.Title AS Album,
	format(
		'%.2f', 
		round(
			count(t.TrackId) * 100.0 / TotalTracksResultSet.TotalTracks, 
			2
		)
	) AS PercentagePurchased
FROM Customer c
JOIN Invoice i ON c.CustomerId = i.CustomerId 
JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId 
JOIN Track t ON il.TrackId = t.TrackId 
JOIN Album a ON t.AlbumId = a.AlbumId 
JOIN (
	SELECT 
		COUNT(t.AlbumId) AS TotalTracks,
		a.Title AS ResultSetTitle
	FROM Track t 
	JOIN Album a ON t.AlbumId = a.AlbumId 
	GROUP BY a.AlbumId
) AS TotalTracksResultSet 
  ON TotalTracksResultSet.ResultSetTitle = a.Title 
GROUP BY Customer, Album
ORDER BY Customer asc;



-- first thing I like to do is organize my column structure
SELECT 
	? AS Customer,
	? AS Albumm
	? AS PercentagePurchased
FROM ?

-- we can do string concatenation for the fist column of data
-- we can set the ordering of the column now as well
SELECT 
	c.FirstName || ' ' || c.LastName AS Customer,
	? AS Album,
	? AS PercentagePurchased
FROM Customer c
ORDER BY Customer asc;

-- in order to gain access to the Album table we need to chain
-- multiple join statements together
SELECT 
	c.FirstName || ' ' || c.LastName AS Customer,
	a.Title AS Album,
	? AS PercentagePurchased
FROM Customer c
JOIN Invoice i ON c.CustomerId = i.CustomerId 
JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId 
JOIN Track t ON il.TrackId = t.TrackId 
JOIN Album a ON t.AlbumId = a.AlbumId 
ORDER BY Customer asc;
-- remember: 'join' defaults to inner join, so only records that have
-- a match between a foreign and primary key are returned and matched together
-- use the query below to see an example of how this works
SELECT c.customerid, invoiceid FROM Customer c 
JOIN Invoice i ON c.CustomerId = i.CustomerId;

/*
 * We now have a somewhat complex task ahead of us: we need to acquire
 * the following pieces of information in order to determine the 
 * percentage of songs purchased from each album that a customer has
 * made a purchase of one or tracks from:
 * 	- total number of tracks in a album
 * 	- calculate how many tracks a customer has purchased from the album
 * 	- figure out percentage of songs purchased based off total tracks
 * 	  and tracks purchased
 * 
 * Keep in mind, we need to do this for each customer and each album
 * they have purchased tracks from 
 * 
 * we can break this down in to individual steps: step one is figure
 * out how many tracks are in each album
 */


SELECT 
	COUNT(t.AlbumId) AS TotalTracks,
	a.Title
FROM Track t 
JOIN Album a ON t.AlbumId = a.AlbumId 
GROUP BY a.AlbumId
ORDER BY a.Title ASC;

/*
 * The query above gives us the total tracks for each album: now we
 * need to add the data found by this query in to our main query. We can
 * do this by joining the result set of the query to our main chain of
 * joins. We can accomplish this with a sub query
 */

SELECT 
	c.FirstName || ' ' || c.LastName AS Customer,
	a.Title AS Album,
	? AS PercentagePurchased
FROM Customer c
JOIN Invoice i ON c.CustomerId = i.CustomerId 
JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId 
JOIN Track t ON il.TrackId = t.TrackId 
JOIN Album a ON t.AlbumId = a.AlbumId 
JOIN (
	SELECT 
		COUNT(t.AlbumId) AS TotalTracks,
		a.Title AS ResultSetTitle
	FROM Track t 
	JOIN Album a ON t.AlbumId = a.AlbumId 
	GROUP BY a.AlbumId
) AS TotalTracksResultSet 
  ON TotalTracksResultSet.ResultSetTitle = a.Title 
ORDER BY Customer asc;

/*
 * Now that we have access to the total number of tracks for each album
 * we need to find the total number of tracks purchased by each customer.
 * We can use the count method again, and adjust our query so that
 * the result set is grouped by customer and album
 * 
 */

SELECT 
	c.FirstName || ' ' || c.LastName AS Customer,
	a.Title AS Album,
	count(t.TrackId) / TotalTracksResultSet.TotalTracks  AS PercentagePurchased
FROM Customer c
JOIN Invoice i ON c.CustomerId = i.CustomerId 
JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId 
JOIN Track t ON il.TrackId = t.TrackId 
JOIN Album a ON t.AlbumId = a.AlbumId 
JOIN (
	SELECT 
		COUNT(t.AlbumId) AS TotalTracks,
		a.Title AS ResultSetTitle
	FROM Track t 
	JOIN Album a ON t.AlbumId = a.AlbumId 
	GROUP BY a.AlbumId
) AS TotalTracksResultSet 
  ON TotalTracksResultSet.ResultSetTitle = a.Title 
GROUP BY Customer, Album
ORDER BY Customer asc;

/*
 * This is a valid query, but the database will round off the value
 * and either return a 0 or 1 depending on the actual percentage of
 * songs purchased. We have a few ways of handling this. For starters,
 * in order for us to get a numeric value that is more meaningful for
 * us to read we can multiply the value (purchased/total) by 100 in
 * order to have an easier number to read
 */

-- make sure to multiply by 100.0 before dividing
SELECT 
	c.FirstName || ' ' || c.LastName AS Customer,
	a.Title AS Album,
	count(t.TrackId) * 100.0 / TotalTracksResultSet.TotalTracks AS PercentagePurchased
FROM Customer c
JOIN Invoice i ON c.CustomerId = i.CustomerId 
JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId 
JOIN Track t ON il.TrackId = t.TrackId 
JOIN Album a ON t.AlbumId = a.AlbumId 
JOIN (
	SELECT 
		COUNT(t.AlbumId) AS TotalTracks,
		a.Title AS ResultSetTitle
	FROM Track t 
	JOIN Album a ON t.AlbumId = a.AlbumId 
	GROUP BY a.AlbumId
) AS TotalTracksResultSet 
  ON TotalTracksResultSet.ResultSetTitle = a.Title 
GROUP BY Customer, Album
ORDER BY Customer asc;

/*
 * 	This gives us the percentage, but it gives us more decimal places
 *  than needed. We have a couple options for solving this issue. One
 *  option is the round function
 */

SELECT 
	c.FirstName || ' ' || c.LastName AS Customer,
	a.Title AS Album,
	round(count(t.TrackId) * 100.0 / TotalTracksResultSet.TotalTracks, 2) AS PercentagePurchased
FROM Customer c
JOIN Invoice i ON c.CustomerId = i.CustomerId 
JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId 
JOIN Track t ON il.TrackId = t.TrackId 
JOIN Album a ON t.AlbumId = a.AlbumId 
JOIN (
	SELECT 
		COUNT(t.AlbumId) AS TotalTracks,
		a.Title AS ResultSetTitle
	FROM Track t 
	JOIN Album a ON t.AlbumId = a.AlbumId 
	GROUP BY a.AlbumId
) AS TotalTracksResultSet 
  ON TotalTracksResultSet.ResultSetTitle = a.Title 
GROUP BY Customer, Album
ORDER BY Customer asc;

-- we've rounded the values, but we still want .00 if there is no
-- other decimal value. We can use the format next to ensure we still
-- get .00 if there are no other numbers to place

SELECT 
	c.FirstName || ' ' || c.LastName AS Customer,
	a.Title AS Album,
	format(
		'%.2f', 
		round(
			count(t.TrackId) * 100.0 / TotalTracksResultSet.TotalTracks, 
			2
		)
	) AS PercentagePurchased
FROM Customer c
JOIN Invoice i ON c.CustomerId = i.CustomerId 
JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId 
JOIN Track t ON il.TrackId = t.TrackId 
JOIN Album a ON t.AlbumId = a.AlbumId 
JOIN (
	SELECT 
		COUNT(t.AlbumId) AS TotalTracks,
		a.Title AS ResultSetTitle
	FROM Track t 
	JOIN Album a ON t.AlbumId = a.AlbumId 
	GROUP BY a.AlbumId
) AS TotalTracksResultSet 
  ON TotalTracksResultSet.ResultSetTitle = a.Title 
GROUP BY Customer, Album
ORDER BY Customer asc;

-- and this gives us a solution to the coding challenge!


