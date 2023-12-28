import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {GameService} from "../../services/game.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-game-from',
  templateUrl: './game-from.component.html',
  styleUrls: ['./game-from.component.css']
})
export class GameFromComponent implements OnInit,OnDestroy{
  // @ts-ignore
  gameForm: FormGroup;
  private subscriptions: Subscription=new Subscription();
  showSnackbar: boolean=false;
  snackbarMessage: string | undefined;
  snackbarClass: string ='custom-snackbar';
  constructor(private formBuilder: FormBuilder,
              private gameService: GameService){}

  ngOnInit(): void {
    this.gameForm=this.formBuilder.group({
      title:['',Validators.required],
      genre:['',Validators.required],
      price:['',Validators.required],
      developer:['',Validators.required],
      stock:['',Validators.required],
      releaseDate:['',Validators.required],
      idPublisher:['',Validators.required],
    });
  }
  onSubmit(){
    if(this.gameForm.valid){
      const formData=this.gameForm.value;
    const insertGameSubscription= this.gameService.insertGame(
       formData.title,
       formData.genre,
       formData.price,
       formData.developer,
       formData.stock,
       formData.releaseDate,
       formData.idPublisher
     ).subscribe(
       response => {
       console.log(response);
       this.showMessage(response,'alert-success');
     },
       error => {
          console.error(error);
          this.showMessage(error,'alert-danger');
          // Additional logic...
       });
    this.subscriptions.add(insertGameSubscription);
    }
  }
  private showMessage(message: string,cssClass:string): void {
    this.snackbarMessage=message;
    this.snackbarClass=`custom-snackbar ${cssClass}`;
    this.showSnackbar=true;
    setTimeout(()=>{
      this.showSnackbar=false;
    },3000);
  }
  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

}
