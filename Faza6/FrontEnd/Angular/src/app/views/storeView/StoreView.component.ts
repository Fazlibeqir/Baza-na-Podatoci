import {Component, ElementRef, OnInit, ViewChild} from "@angular/core";
import {StoreView} from "../../model/Views/StoreView";
import {StoreViewService} from "../../services/viewService/StoreView.service";
// import {SharedService} from "../../services/sharedService/shared.service";

@Component({
    selector: 'app-pre',
    templateUrl: './StoreView.component.html',
    styleUrls: ['./StoreView.component.css']
})
export class StoreViewComponent implements OnInit{
    storeViews:StoreView[]=[];
    // searchTerm=this.sharedService.getSearchTerm();
    // @ts-ignore
    @ViewChild('cardGroup',{static:true}) cardGroup: ElementRef;
    cardGroupWidth:string="1861px";
    constructor(private storeViewService:StoreViewService
                // ,private sharedService:SharedService
    ){}
    ngOnInit(): void {
      this.getItems();
      // this.subToSearchTerm();
    }
    getItems(){
      this.storeViewService.getAllStoreView().subscribe((data:StoreView[])=>{
        this.storeViews=data.reverse();
        // this.filterItems();
        this.updateCardGroupWidth();
      });
    }
    // filterItems(){
    //   const searchTerm=this.searchTerm.toLowerCase();
    //   if (searchTerm === null || searchTerm.trim() === '') {
    //     this.getItems();
    //     return;
    //   }
    //   const searchTermLower=searchTerm.toLowerCase();
    //   this.storeViews = this.storeViews.filter(item =>
    //     item.title.toLowerCase().includes(searchTermLower) ||
    //     item.genre.toLowerCase().includes(searchTermLower) ||
    //     item.publisher_name.toLowerCase().includes(searchTermLower) ||
    //     item.website.toLowerCase().includes(searchTermLower) ||
    //     item.platform_name.toLowerCase().includes(searchTermLower) ||
    //     item.manufacturer.toLowerCase().includes(searchTermLower)
    //   );
    //
    // }

  private updateCardGroupWidth() {
    const cardWidth=310;
    const totalWidth=this.storeViews.length*cardWidth;
    this.cardGroupWidth=totalWidth+"px";
    }
    // private subToSearchTerm(){
    //   this.sharedService.searchTerm$.subscribe((data:string)=>{
    //     this.searchTerm=data;
    //     this.filterItems();
    //   });
    // }
}
