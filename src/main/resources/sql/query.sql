SELECT     product_id, customer_id, title, order_date
 FROM       order_product
 RIGHT JOIN product p on p.id = order_product.product_id
 WHERE      order_date < '2018-08-30'
 ORDER BY   title;

