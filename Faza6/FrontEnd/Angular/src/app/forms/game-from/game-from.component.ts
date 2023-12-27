import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {GameService} from "../../services/game.service";
import {Subscription} from "rxjs";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-game-from',
  templateUrl: './game-from.component.html',
  styleUrls: ['./game-from.component.css']
})
export class GameFromComponent implements OnInit,OnDestroy{
  // @ts-ignore
  gameForm: FormGroup;
  private subscriptions: Subscription=new Subscription();
  constructor(private formBuilder: FormBuilder,
              private gameService: GameService,
              private snackBar:MatSnackBar){}

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
       this.showSnackBar(response);
     },
       error => {
          console.error(error);
          this.showSnackBar(error);
          // Additional logic...
       });
    this.subscriptions.add(insertGameSubscription);
    }
  }
  private showSnackBar(message: string): void {
    this.snackBar.open(message, 'Close', {
      duration: 3000,
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: ['centered-snack-bar']
    });
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

}
