import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

private customers: Customer[];

private newCustomer: Customer;

  constructor() { }

  ngOnInit() {
    this.customers = [
{
  name: "Tony",
  data: "14/11/01",
  email: "tony@gmail.com"
},
{
  name: "Prussian",
  data: "02/09/03",
  email: "Prussian@gmail.com"
},
{
  name: "Leipzig",
  data: "02/05/03",
  email: "Leipzig@gmail.com"
}
];

this.newCustomer = new Customer();
this.newCustomer.name = "Trafalgar"
this.newCustomer.data = "21/10/1805"
this.newCustomer.email = "Trafalgar@gmail.com"
}
  
  onSubmit(customerForm: NgForm) {
    if (customerForm.valid) {
      
      //this.newCustomer.name = this.name;
      //this.newCustomer.data = this.data;
      //this.newCustomer.email = this.email;
      this.customers.push(this.newCustomer)
    }
  }
}

export class Customer {
  name: String;
  data: String;
  email: String;
}