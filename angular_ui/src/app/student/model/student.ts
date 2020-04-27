export interface Student {
     id: number,
     nic: string,
     firstName: string,
     lastName: string,
     dob: Date,
     regDate:Date,
     gender: string,
     currentStatus: string,
     telephones:string,
   //   telephones: [ {
   //      number: string
   //   }],

     addresses: {
      lane1: string,
      lane2: string,
      city: string
    }
}
// {
//     "id": 1,
//     "nic": "768668777",
//     "firstName": "lene",
//     "lastName": "lastlene",
//     "dob": "1994-10-10",
//     "regDate": "2020-10-10",
//     "gender": "Female",
//     "currentStatus": "Active",
//     "telephones": [{

// }],
//     "addresses": {
//         "id": 1,
//         "lane1": "lane 100",
//         "lane2": "lane 101",
//         "city": "kegalle"
//     }
// }