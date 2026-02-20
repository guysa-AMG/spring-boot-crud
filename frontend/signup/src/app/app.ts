import { Component, computed, signal} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {} from "@angular/common";
import { sign } from 'node:crypto';
import { Interface } from 'node:readline';
import {ValidationError, form,FormField, EmailValidationError, FieldTree}from "@angular/forms/signals"
import { Validators } from '@angular/forms';
import { Console } from 'node:console';
interface Formz{
  name:string;
  email:string;
  surname:string;
}

class EmailError implements ValidationError.WithField{
  fieldTree: FieldTree<unknown, string | number>;
  kind: string="email";
  message?: string | undefined;

  constructor(message:string,tree:FieldTree<unknown, string | number>){
    this.message = message;
    this.fieldTree=tree;
  }
}

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,FormField],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Registration');
  protected loading = signal<boolean>(false);
  private formstruct = signal<Formz>({name:"",email:"",surname:""});

  signUpData = form(this.formstruct);

   submit():void{


    let uname =this.signUpData.name().value;
    let usname =this.signUpData.surname().value;
    let uemail =this.signUpData.email().value;
    if (!this.checkEmail(uemail())){
        console.log("BAD EMAIL")
        this.signUpData.email().errors().push(new EmailError("invalid email",this.signUpData))
         alert(`bad email |${uemail()}|`);
        return
    }
    this.loading.set(true);
     fetch("http://localhost:8080/adduser",
      {
        method:"POST",
        headers: {
          "Content-Type": "application/json",
        },
        body:JSON.stringify(
                    {name:uname,
                      surname:usname,
                      email:uemail})}).finally(()=>{this.loading.set(false);})


  }

  checkEmail ( mail:string):boolean{

    let email_pattern= /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return email_pattern.test(mail);
  }

}
