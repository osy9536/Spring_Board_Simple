# Spring_Board_Simple
### Use Case 
------
<img src ="https://user-images.githubusercontent.com/76714304/216903461-88b2822b-e2c7-4223-87c6-7a8d28007baf.png" width = "300" heigh = "400"/>
------

### API 명세서
------
|Method|URL|Request|Response|
|:---:|:---:|:---:|:---------:|
|GET|/api/board||[
{
"createdAt": "2023-02-07T11:14:50.850221",
"modifiedAt": "2023-02-07T11:14:50.850221",
"id": 3,
"title": "제목3",
"userName": "이름3",
"comment": "pw3"
},
{
"createdAt": "2023-02-07T11:14:44.736994",
"modifiedAt": "2023-02-07T11:14:44.736994",
"id": 2,
"title": "제목2",
"userName": "이름2",
"comment": "pw2"
},
{
"createdAt": "2023-02-07T11:14:37.092625",
"modifiedAt": "2023-02-07T11:14:37.092625",
"id": 1,
"title": "제목1",
"userName": "이름1",
"comment": "pw1"
}
]|
|GET|/api/board/{id}||{
"createdAt": "2023-02-07T11:14:37.092625",
"modifiedAt": "2023-02-07T11:14:37.092625",
"id": 1,
"title": "제목1",
"userName": "이름1",
"comment": "pw1"
}|
|POST|/api/board|{
"title" : "제목3",
"userName" : "이름3",
"password" : "pw3",
"comment" : "내용3"
}|{
"createdAt": "2023-02-07T11:14:50.8502205",
"modifiedAt": "2023-02-07T11:14:50.8502205",
"id": 3,
"title": "제목3",
"userName": "이름3",
"comment": "pw3"
}|
|PUT|/api/board/{id}|{
"title" : "제목1수정",
"userName" : "이름1수정",
"password" : "pw1",
"comment" : "내용1수정"
}|{
"createdAt": "2023-02-07T11:14:37.092625",
"modifiedAt": "2023-02-07T11:17:54.6647442",
"id": 1,
"title": "제목1수정",
"userName": "이름1수정",
"comment": "내용1수정"
}|
|DELETE|/api/board/{id}/{password}||{
    "success": true
}|
