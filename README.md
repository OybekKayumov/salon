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
    post
    http://localhost:5002/api/salons
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
    
    update salon
    http://localhost:5002/api/salons/152
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

### categories

    `
    post category
    http://localhost:5003/api/categories/salon-owner
        {
           "name": "Hair Color",
           "image": "www.images.com/4"    
        }

    get category
        http://localhost:5003/api/categories/salon/1

    delete category

        http://localhost:5003/api/categories/salon-owner/1
    `
### service offering

    --- 1. create new project in salon folder
    --- 2. load maven
    --- 3. copy into microservices folder new project
    --- 4. delete .idea folder
    --- 5. open microservices in idea
    --- 6. load maven if asks
    --- 7. update app.propertires to connect to db
    --- 8. create a new db
    --- 9. run new microservice

    post 
    http://localhost:5004/api/service-offering/salon-owner

        {
            "name": "Aromatherapy",
            "description": "a massage ...",
            "price": 1299.99,
            "duration": 90,
            "category": 1,
            "image": "https://images.com/6"
        }

    get all services of salon
    http://localhost:5004/api/service-offering/salon/1

    get services by id
    http://localhost:5004/api/service-offering/2

### booking service

    
    


