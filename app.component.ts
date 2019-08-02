import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  private parkings:any = [];

  constructor(private httpClient: HttpClient){}

  ngOnInit(): void {
    const headers = new HttpHeaders({ 'Content-Type': 'text/plain', 'Access-Control-Allow-Origin':'http://localhost:4200'}); 
    this.httpClient.get('localhost:8080/api' + '/api/parkings', {headers}).subscribe((res)=>{
      console.log(res);
      this.parkings = res;
  });
  }

  vehicleForm = new FormGroup({
    vehicleLot: new FormControl(''),
    vehicleNumber: new FormControl(''),
    vehicleDuration: new FormControl(''),
    vehicleAmount: new FormControl('')
  });

  onSubmit() {
    console.warn(this.vehicleForm.value);



   let parkingObj = {
      lot: this.vehicleForm.controls.vehicleLot.value,
      parking_duration: this.vehicleForm.controls.vehicleDuration.value, 
      vehicle_number: this.vehicleForm.controls.vehicleNumber.value, 
      parkingAmount: this.vehicleForm.controls.vehicleAmount.value
    };
    console.log(parkingObj);
    this.httpClient.post('localhost:8080/api' + '/api/parkings', parkingObj).subscribe((res)=>{
      console.log(res);
      this.parkings = res;
  });
  }

  calculateAmount(event){
    
   let duration = this.vehicleForm.controls.vehicleDuration.value;
   if(duration<=60){
    this.vehicleForm.controls.vehicleAmount.setValue('20');
   }
   else {
     let amount = 20+(duration-60)*0.333;
    this.vehicleForm.controls.vehicleAmount.setValue(amount);
   }
  }
  

}