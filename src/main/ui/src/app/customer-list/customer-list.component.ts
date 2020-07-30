import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

private customers: Customer[];

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
  }
  
  onSubmit(customerForm: NgForm, customerName: String, customerData: String, customerEmail: String) {
    if (customerForm.valid) {
      let newCustomer = new Customer();
      newCustomer.name = customerName;
      newCustomer.data = customerData;
      newCustomer.email = customerEmail;
      this.customers.push(newCustomer)
    }
  }
}

export class Customer {
  name: String;
  data: String;
  email: String;
}