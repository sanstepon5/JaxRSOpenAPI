### Ajouter un prof
```shell
curl -X POST http://localhost:8080/teacher \
  -H "Content-Type: application/json" \
  -d '{
    "username": "profA",
    "firstName": "Alice",
    "lastName": "Durand"
  }'
```

### Ajouter un étudiant
```shell
curl -X POST http://localhost:8080/student \
  -H "Content-Type: application/json" \
  -d '{
    "username": "student1",
    "studentNumber": 1111,
    "age": 20
  }'
```

### Ajouter des questions
```shell
curl -X POST http://localhost:8080/question \
  -H "Content-Type: application/json" \
  -d '{
    "questionText": "What is the capital of France?"
  }'
```

```shell
curl -X POST http://localhost:8080/question \
  -H "Content-Type: application/json" \
  -d '{
    "questionText": "What is 2 + 2?"
  }'
```

### Créer un quiz. 
Notez que les ids peuvent changer, donc il est mieux d'abord voir les
ids existants.

```shell
curl http://localhost:8080/student/
```
```shell
curl http://localhost:8080/teacher/
```
```shell
curl http://localhost:8080/question/
```

```shell
curl -X POST http://localhost:8080/quiz \
  -H "Content-Type: application/json" \
  -d '{
    "accessCode": 1001,
    "teacherId":  1 ,
    "studentIds": [152],
    "questionIds": [1, 2]
  }'
```

### Créer une réponse
```shell
curl -X POST http://localhost:8080/answer \
  -H "Content-Type: application/json" \
  -d '{
    "answerText": "Paris",
    "questionId": 1,
    "correct": true
  }'
```