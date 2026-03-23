### user-service
    `
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
    `
### salon-service

`
- post
- http://localhost:5002/api/salons
    {
        "name": "Beauty Salon",
        "address": "123 Main Str, Downtown",
        "phoneNumber": "99 4567890 222",
        "email": "salon1@mail.com",    
        "city": "Mumbai",
        "openTime": "09:00:00",
        "closeTime": "20:00:00",
        "images": ["www.images.com/1","www.images.com/2"]  
    }
`
`
- update salon
- http://localhost:5002/api/salons/152

    {
        "name": "Beauty Salon",
        "images": [
                "www.images.com/1",
                "www.images.com/2"
            ],
        "address": "456 Main Str, City Center",
        "phoneNumber": "99 4567890 333",
        "email": "salon1@mail.com",        
        "city": "Dely",
        "ownerId": 1,
        "openTime": "08:00:00",
         "closeTime": "21:00:00"
    }
`
    
