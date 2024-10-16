
-- 1
INSERT INTO expenses ( type, name, amount, total_quotes, current_quote, date, month_id) VALUES ( 'delivery', 'Nombre1', 100.00, 5, 2, '2024-05-25', 1);

-- 2
INSERT INTO expenses ( type, name, amount, total_quotes, current_quote, date, month_id) VALUES ( 'home', 'Nombre2', 200.00, 6, 3, '2024-05-25', 1);

-- 3
INSERT INTO expenses ( type, name, amount, total_quotes, current_quote, date, month_id) VALUES ( 'onlineShopping', 'Nombre3', 300.00, 7, 4, '2024-05-27', 1);

-- 4
INSERT INTO expenses ( type, name, amount, total_quotes, current_quote, date, month_id) VALUES ( 'others', 'Nombre4', 400.00, 8, 5, '2024-05-28', 1);

-- 5
INSERT INTO expenses ( type, name, amount, total_quotes, current_quote, date, month_id) VALUES ( 'outings', 'Nombre5', 500.00, 9, 6, '2024-05-29', 1);

INSERT INTO months (month, year, available_amount, is_finalized) VALUES (6, 2024, 25000, false);
