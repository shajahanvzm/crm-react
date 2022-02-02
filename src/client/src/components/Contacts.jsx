import React, { Component } from 'react';
import AddContact from './AddContact';
import SingleContact from './SingleContact';


class Contacts extends Component {
constructor(props) {
    super(props);
    this.state = {
        contacts: []
    };
}

componentDidMount() {
    fetch('http://localhost:8080/api/v1/contact/')
    .then(response => response.json())
    .then(data => this.setState({ contacts: data }))
}

    render() {
        return (
            <div>
              <div className="row">
                  <AddContact />
              </div>
              <div className="row">
                  {this.state.contacts.map((item)=>(
                      <SingleContact key={item.id} item={item}/>
                  ))}
                 
              </div>
            </div>
        );
    }
}

export default Contacts;