
--SELECT * FROM users;
--SELECT * FROM products;

--SELECT price , SUM(price * qty) as 'subtotal' FROM products GROUP BY price ORDER BY subtotal ASC limit 1;
--SELECT price , SUM(price * qty) as 'subtotal' FROM products GROUP BY price ORDER BY subtotal DESC;
--SELECT sum(price * subtotal) FROM products_group;
SELECT  * FROM products_group; --執行前請先建立 View (請先執行 create_view.sql)
