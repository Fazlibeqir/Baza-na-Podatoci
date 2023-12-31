import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {EntityService} from "../../services/entity.service";
import {Costumer} from "../../model/costumer";
import {Publisher} from "../../model/Publisher";
import {Platform} from "../../model/Platform";
import {Promotion} from "../../model/promotion";

@Component({
  selector: 'app-entity-forms',
  templateUrl: './entity-forms.component.html',
  styleUrls: ['./entity-forms.component.css']
})
export class EntityFormsComponent implements OnInit, OnDestroy{
  // @ts-ignore
  costumerForm: FormGroup;
  // @ts-ignore
  publisherForm: FormGroup;
  // @ts-ignore
  platformForm: FormGroup;
  // @ts-ignore
  promotionForm: FormGroup;

  private subCostumer: Subscription=new Subscription();
  private subPlatform: Subscription=new Subscription();
  private subPromotion: Subscription=new Subscription();
  private subPublisher: Subscription=new Subscription();
  showSnackbar: boolean=false;
  snackbarMessage: string | undefined;
  snackbarClass: string ='custom-snackbar';

  constructor(private formBuilder:FormBuilder,
              private entityService:EntityService) { }



  ngOnInit(): void {
    this.buildCostumerForm();
    this.buildPublisherForm();
    this.buildPlatformForm();
    this.buildPromotionForm();
  }


  private buildCostumerForm() {
    this.costumerForm=this.formBuilder.group({
      nameCostumer:['',Validators.required],
      email:['',Validators.required],
      password:['',Validators.required],
    });
  }
  onCostumerSubmit(){
    if(this.costumerForm.valid){
      const formData=this.costumerForm.value;
      const newCostumer = new Costumer(
        0,
        formData.nameCostumer,
        formData.email,
        formData.password);
      const insertCostumerSubscription= this.entityService.addCostumer(
        newCostumer
      ).subscribe(response =>{
        this.showMessage(response,'alert-success');
      },
        error => {
          this.showMessage(error,'alert-danger');
        });
      this.subCostumer.add(insertCostumerSubscription);
    }
  }

  private buildPublisherForm() {
    this.publisherForm=this.formBuilder.group({
      namePublisher:['',Validators.required],
      website:['',Validators.required],
      country:['',Validators.required],
    });
  }
  onPublisherSubmit(){
    if(this.publisherForm.valid){
      const formData=this.publisherForm.value;
      const newPublisher =new Publisher(
        0,
        formData.namePublisher,
        formData.website,
        formData.country);
      const insertPublisherSubscription= this.entityService.addPublisher(
        newPublisher
      ).subscribe(response =>{
          this.showMessage(response,'alert-success');
        },
        error => {
          this.showMessage(error,'alert-danger');
        });
      this.subPublisher.add(insertPublisherSubscription);
    }
  }


  private buildPlatformForm() {
    this.platformForm=this.formBuilder.group({
      namePlatform:['',Validators.required],
      manufacturer:['',Validators.required],
      releaseDate:['',Validators.required],
    });
  }
  onPlatformSubmit(){
    if(this.platformForm.valid){
      const formData=this.platformForm.value;
      const newPlatform =new Platform(
        0,
        formData.namePlatform,
        formData.manufacturer,
        formData.releaseDate);
      const insertPlatformSubscription= this.entityService.addPlatform(
        newPlatform
      ).subscribe(response =>{
          this.showMessage(response,'alert-success');
        },
        error => {
          this.showMessage(error,'alert-danger');
        });
      this.subPlatform.add(insertPlatformSubscription);
    }
  }

  private buildPromotionForm() {
    this.promotionForm=this.formBuilder.group({
      namePromotion:['',Validators.required],
      discount:['',Validators.required],
      startDate:['',Validators.required],
      endDate:['',Validators.required],
    });
  }
  onPromotionSubmit(){
    if(this.promotionForm.valid){
      const formData=this.promotionForm.value;
      const newPromotion =new Promotion(
        0,
        formData.namePromotion,
        formData.startDate,
        formData.endDate,
        formData.discount);
      const insertPromotionSubscription= this.entityService.addPromotion(
        newPromotion
      ).subscribe(response =>{
          this.showMessage(response,'alert-success');
        },
        error => {
          this.showMessage(error,'alert-danger');
        });
      this.subPromotion.add(insertPromotionSubscription);
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
    this.subCostumer.unsubscribe();
    this.subPlatform.unsubscribe();
    this.subPromotion.unsubscribe();
    this.subPublisher.unsubscribe();
  }
}
