```
curl --request POST \
--url http://localhost:8080/quiz/ \
--header 'Content-Type: application/json' \
--header 'User-Agent: insomnia/11.0.2' \
--data '{
"accessCode": 12345,
"teacher": {
"id": 1
},
"questions": [
{ "id": 1 }
],
"students": [
{ "id": 1 }
]
}'
```


```
curl --request POST \
--url http://localhost:8080/teacher/ \
--header 'Content-Type: application/json' \
--header 'User-Agent: insomnia/11.0.2' \
--data '{  
"firstName": "SQL",
"lastName": "Alice",
"username":"John"
}'
```

```
curl --request POST \
  --url http://localhost:8080/student/ \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/11.0.2' \
  --data '{  
	"studentNumber": 1452554,
  "age": 10
}'
```