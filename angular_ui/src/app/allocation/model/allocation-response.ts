export interface AllocationResponse {
    "allocation": {
        "allocationId": number,
        "studentId": number,
        "courseId": number,
        "employeeId": number,
        "fromDate": Date,
        "toDate": Date
    },
    "student": {
        id: number,
        nic: string,
        firstName: string,
        lastName: string,
        dob: Date,
        regDate: Date,
        gender: string,
        currentStatus: string,
        telephones: string,

        addresses: {
            lane1: string,
            lane2: string,
            city: string
        }
    },
    "course": {
        id: number,
        name: String,
        duration: number,
        description: string,
        regDate: Date,
        currentStatus: string,
        courseType: string
    }

}
// {
//     "allocation": {
//         "allocationId": 1,
//         "studentId": 1,
//         "courseId": 1,
//         "employeeId": 1,
//         "fromDate": "2020-10-11",
//         "toDate": "2020-10-12"
//     },
//     "student": {
//         "id": 1,
//         "nic": "889768727v",
//         "firstName": "Nimalzxz",
//         "lastName": "Jayasena",
//         "dob": "1988-12-10",
//         "regDate": "2019-10-10",
//         "gender": "Male",
//         "currentStatus": "Available",
//         "telephones": "0736543362",
//         "addresses": {
//             "id": 3,
//             "lane1": "lane 100",
//             "lane2": "lane 101",
//             "city": "kegalle" 
//         }
//     },
//     "course": {
//         "id": 1,
//         "name": "Auto CAD",
//         "duration": 6,
//         "description": "Basics and more",
//         "regDate": "2020-10-10",
//         "currentStatus": "Active",
//         "courseType": "Advanced"
//     }
// }