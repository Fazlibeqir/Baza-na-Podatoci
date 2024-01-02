import {Component, OnDestroy, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {GameService} from "../../services/game.service";
import {Subscription} from "rxjs";
import {Publisher} from "../../model/Publisher";
import {Platform} from "../../model/Platform";
import {Game} from "../../model/game";

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
    this.buildFrom();
    this.getPublishers();
    this.getPlatforms();
  }
  publishers:Publisher[]=[];
  platforms:Platform[]=[];
  getPublishers(){
    this.gameService.getPublishers().subscribe((data:any)=>{
      this.publishers=data;
    });
  }
  getPlatforms(){
    this.gameService.getPlatforms().subscribe((data:any)=>{
      this.platforms=data;
    });
  }
  buildFrom(): void{
    this.gameForm=this.formBuilder.group({
    title:['',Validators.required],
    genre:['',Validators.required],
    image:['',[Validators.required,this.validateImageUrl]],
    price:['',Validators.required],
    developer:['',Validators.required],
    stock:['',Validators.required],
    releaseDate:['',Validators.required],
    selectedPublisher:['',Validators.required],
    selectedPlatform:['',Validators.required]
  });
  }
  validateImageUrl(control:AbstractControl){
    const url=control.value as string
    if(!url.startsWith('https://')){
      return {invalidUrl:true};
    }
    return null;
  }
  onSubmit(){
    if(this.gameForm.valid){
      const formData=this.gameForm.value;
      const newGame = new Game(
        0,
        formData.title,
        formData.genre,
        formData.image,
        formData.price,
        formData.developer,
        formData.stock,
        formData.releaseDate,
        formData.selectedPublisher,
        formData.selectedPlatform
      );
      const insertGameSubscription= this.gameService.insertGame(newGame).subscribe(
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
