import {Component,OnInit} from "@angular/core";
import {StoreView} from "../model/StoreView";
import {StoreViewService} from "../services/StoreView.service";

@Component({
    selector: 'app-StoreView',
    templateUrl: './StoreView.component.html',
    styleUrls: ['./StoreView.component.css']
})
export class StoreViewComponent implements OnInit{
    storeViews:StoreView[]=[];
    constructor(private StoreViewService:StoreViewService){}
    ngOnInit(): void {
        this.StoreViewService.getAllStoreView().subscribe((data:StoreView[])=>{
            this.storeViews=data;
        }
        );
    }
}
