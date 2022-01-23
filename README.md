#Парсер SQL запросов

##Краткое описание
Приложение позволяет перевести SQL запрос в  JSON объект

##Порядок запуска
* Скачиваете проект с https://github.com/ponomain/TestTaskForErTelecom
* В 'src/main/resources/query.sql' вбираете свой SQL запрос
* Запускаете Main.java в 'src/main/java/ru/er/app'
* На выходе получается JSON объект, полученный из нашего запроса

##Примеры входных и выходных данных
###SQL
```SQL
   SELECT customer_id, product_id
   FROM orders_product
   RIGHT JOIN customers on orders_product.customer_id = customers.id
   WHERE customers.id < 10
   GROUP BY product_id
```

###JSON
```JSON
  { 
   "CRUD" : ["SELECT"]
   "VALUES" : ["customer_id, product_id"]
   "FROM" : ["orders_product"]
   "RIGHT JOIN" : ["customers on orders_product.customer_id = customers.id"]
   "WHERE" : ["customers.id<10"]
   "GROUP BY" : ["product_id"]
}
```