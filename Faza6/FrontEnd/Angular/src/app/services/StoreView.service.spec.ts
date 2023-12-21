import {TestBed} from "@angular/core/testing";
import {StoreViewService} from "./StoreView.service";

describe('StoreViewService',()=>{
    let service:StoreViewService;

    beforeEach(()=>{
        TestBed.configureTestingModule({});
        service=TestBed.inject(StoreViewService);
    });

    it('should be created',()=>{
        expect(service).toBeTruthy();
    });
});
