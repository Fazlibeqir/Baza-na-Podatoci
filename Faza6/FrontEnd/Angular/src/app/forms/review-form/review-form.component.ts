import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder,FormGroup,Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {Costumer} from "../../model/costumer";
import {Game} from "../../model/game";
import {ReviewService} from "../../services/review.service";

@Component({
  selector: 'app-review-form',
  templateUrl: './review-form.component.html',
  styleUrls: ['./review-form.component.css']
})
export class ReviewFormComponent implements OnInit,OnDestroy{
  // @ts-ignore
  reviewForm: FormGroup;
  private subscriptions: Subscription=new Subscription();
  showSnackbar: boolean=false;
  snackbarMessage: string | undefined;
  snackbarClass: string ='custom-snackbar';
  constructor(private formBuilder: FormBuilder,
              private reviewsService: ReviewService){}
  ngOnInit(): void {
    this.buildForm();
    this.getGames();
    this.getCostumers();
  }
  costumers:Costumer[]=[];
  games:Game[]=[];
getGames(){
  this.reviewsService.getGames().subscribe((data:any)=>{
    this.games=data;
  });
}
getCostumers(){
  this.reviewsService.getCostumers().subscribe((data:any)=>{
    this.costumers=data;
  });
}


  private buildForm() {
    this.reviewForm=this.formBuilder.group({
      rating:['',Validators.required],
      comment:['',Validators.required],//comment
      selectedUser:['',Validators.required],
      selectedGame:['',Validators.required]
    });
  }
  onSubmit(){
    if(this.reviewForm.valid){
      const formData=this.reviewForm.value;

      const insertReviewSubscription= this.reviewsService.insertReview(
        formData.rating,
        formData.comment,
        formData.selectedUser,
        formData.selectedGame
      ).subscribe((data:any)=>{
        this.showMessages(data,'alert-success');
        this.reviewForm.reset();
      },error => {
       this.showMessages(error,'alert-danger')
      });
      this.subscriptions.add(insertReviewSubscription);
    }
  }
  private showMessages(message: string, type: string): void {
    this.snackbarMessage=message;
    this.snackbarClass=`custom-snackbar ${type}`;
    this.showSnackbar=true;
    setTimeout(()=>{
      this.showSnackbar=false;
    },3000);
  }
  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }
}
