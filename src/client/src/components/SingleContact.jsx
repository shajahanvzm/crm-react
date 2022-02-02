import React, { Component } from 'react';

// class SingleContact extends Component {
//     render() {
//         return (
//             <div>
//                 <h1>Single Contact</h1>
//             </div>
//         );
//     }
// }

const SingleContact = ({item}) => (
    <div className="card">
        <div className="card-header">
            {item.firstName} {item.lastName}
        </div>
        <ul className="list-group list-group-flush">
            <li className="list-group-item">Email : {item.email}</li>
        </ul>
    </div>
);
export default SingleContact;