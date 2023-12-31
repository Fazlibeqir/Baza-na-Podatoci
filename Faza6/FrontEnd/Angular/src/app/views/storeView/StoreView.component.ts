import {Component, ElementRef, OnInit, ViewChild} from "@angular/core";
import {StoreView} from "../../model/Views/StoreView";
import {StoreViewService} from "../../services/viewService/StoreView.service";

@Component({
    selector: 'app-pre',
    templateUrl: './StoreView.component.html',
    styleUrls: ['./StoreView.component.css']
})
export class StoreViewComponent implements OnInit{
    storeViews:StoreView[]=[];
    // @ts-ignore
    @ViewChild('cardGroup',{static:true}) cardGroup: ElementRef;
    cardGroupWidth:string="1861px";
    constructor(private StoreViewService:StoreViewService){}
    ngOnInit(): void {
      this.getItems();
    }
    getItems(){
      this.StoreViewService.getAllStoreView().subscribe((data:StoreView[])=>{
        this.storeViews=data;
        this.updateCardGroupWidth();
      });
    }

  private updateCardGroupWidth() {
    const cardWidth=310;
    const totalWidth=this.storeViews.length*cardWidth;
    this.cardGroupWidth=totalWidth+"px";
    }
}
