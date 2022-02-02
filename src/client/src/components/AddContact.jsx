import React, { Component } from 'react';

class AddContact extends Component {
    constructor(props) {
        super(props);
        
    }

    submitContact(event) {
        event.preventDefault();
        let contact = {
            firstName: this.refs.firstName.value,
            lastName: this.refs.lastName.value,
            email: this.refs.email.value
        }

        console.log(contact);

        fetch('http://localhost:8080/api/v1/contact/',{
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(contact),
        })
        .then(response => response.json());

        console.log(contact);
        window.location.reload();
    }

    render() {
        return (
            <div>
                <form onSubmit={this.submitContact.bind(this)}>
                        <div className="mb-3">
                            <label htmlFor="firstName" className="form-label">First Name</label>
                            <input type="text" className="form-control" ref="firstName" name='firstName' />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="lastName" className="form-label">Last Name</label>
                            <input type="text" className="form-control" ref="lastName" name='lastName' />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="email" className="form-label">Email address</label>
                            <input type="email" className="form-control" ref="email" name='email'  />
                        </div>
                        <button type="submit" className="btn btn-primary">Submit</button>
                    </form>
            </div>
        );
    }
}

export default AddContact;