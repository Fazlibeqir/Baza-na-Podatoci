import {Component, OnDestroy, OnInit} from '@angular/core';
import {Game} from "../../model/game";
import {Promotion} from "../../model/promotion";
import {OrderService} from "../../services/order.service";
import {GameService} from "../../services/game.service";
import {PromotionService} from "../../services/promotion.service";
import {AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {Payment} from "../../model/payment";
import {Costumer} from "../../model/costumer";

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit, OnDestroy{
  // @ts-ignore
  orderForm:FormGroup;
  private subscriptions: Subscription=new Subscription();
  showSnackbar: boolean=false;
  snackbarMessage: string | undefined;
  snackbarClass: string ='custom-snackbar';
  games:Game[]=[];
  promotions:Promotion[]=[];
  payments:Payment[]=[];
  costumers:Costumer[]=[];

  constructor(private orderService:OrderService,
              private gameService:GameService,
              private promotionService:PromotionService,
              private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.BuildForm();
    this.getGames();
    this.getPromotions();
    this.getCostumers();
    this.getPayments();
  }
  getGames() {
    this.gameService.getGames().subscribe((data: Game[]) => {
      this.games = data.reverse();
    });
  }
  getPromotions(){
    this.promotionService.getPromotions().subscribe((data:Promotion[])=>{
      this.promotions=data.reverse();
    });
  }
  getCostumers(){
    this.orderService.getCostumers().subscribe((data:Costumer[])=>{
      this.costumers=data.reverse();
    });
  }
  getPayments(){
    this.orderService.getPayments().subscribe((data:Payment[])=>{
      this.payments=data.reverse();
    });
  }

  onOrderSubmit(){
    if (this.orderForm.valid){
      const formData=this.orderForm.value;
      const insertOrderSubscription=this.orderService.insertOrder(
        formData.status,
        formData.order_date,
        formData.total_amount,
        formData.id_costumer,
        formData.id_payment,
        formData.selectedGames,
        formData.selectedPromotions
      ).subscribe(response=>{
        this.showMessage(response,'alert-success');
      },
        error => {
          this.showMessage(error,'alert-danger');
        });
      this.subscriptions.add(insertOrderSubscription);
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


  private BuildForm() {
    this.orderForm=this.formBuilder.group({
      status:['',Validators.required],
      order_date:['',Validators.required],
      total_amount:['',Validators.required],
      id_costumer:['',Validators.required],
      id_payment:['',Validators.required],
      selectedGames:[[],Validators.required],
      selectedPromotions:[[],Validators.required]
    });
  }
  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }
}
