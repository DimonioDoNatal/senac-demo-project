import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers = [
{
  nome: "Tony",
  data: "14/11/01",
  email: "tony@gmail.com"
},
{
  nome: "Prussian",
  data: "02/09/03",
  email: "Prussian@gmail.com"
},
{
  nome: "Leipzig",
  data: "02/05/03",
  email: null
}
];

  constructor() { }

  ngOnInit() {
  }

}
