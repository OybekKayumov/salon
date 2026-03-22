user-service
    create user
    http://localhost:5001/api/users 
    {
    "fullName": "Jane Doe",
    "email": "jane_doe@mail.com",
    "phone": "99 4567890 222",
    "role": "CUSTOMER",
    "password": "123123",
    "username": "Jane"    
    }
    
    get users
    http://localhost:5001/api/users
    
    update user
    http://localhost:5001/api/users/1
    {    
    "fullName": "Jane Doe Updated",
    "username": "Jane new",
    "email": "jane_doe@mail.com",
    "phone": "99 4567890 333",
    "role": "ADMIN",
    "createdDate": "***",
    "updatedDate": "***",
    "password": "123123"
    }
    
    delete user
    http://localhost:5001/api/users/252

salon-service
    
