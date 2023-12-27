import {TestBed} from "@angular/core/testing";
import {UserLibraryViewService} from "./UserLibraryView.service";

describe('UserLibraryViewService',()=>{
    let service:UserLibraryViewService;

    beforeEach(()=>{
        TestBed.configureTestingModule({});
        service=TestBed.inject(UserLibraryViewService);
    });

    it('should be created',()=>{
        expect(service).toBeTruthy();
    });
});


