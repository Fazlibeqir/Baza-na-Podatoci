import {Component,OnInit} from "@angular/core";
import {StoreView} from "../../model/Views/StoreView";
import {StoreViewService} from "../../services/viewService/StoreView.service";

@Component({
    selector: 'app-pre',
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
