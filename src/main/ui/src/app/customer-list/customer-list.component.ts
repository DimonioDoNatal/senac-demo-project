import { Component} from '@angular/core';
import { EmailValidator } from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent {

  customers = [
    {
      name: "Tony",
      born: "1991",
      email: "tony@gmail.com"
    },
    {
      name: "Leipzig",
      born: "1980",
      email: "leipzig22@gmail.com"
    }
  ];

}
