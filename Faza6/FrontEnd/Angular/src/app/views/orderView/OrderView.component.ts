import {Component, OnInit} from '@angular/core';
import {UserLibraryView} from '../../model/Views/UserLibraryView';
import {UserLibraryViewService} from '../../services/viewService/UserLibraryView.service';

@Component({
  selector: 'app-pro',
  templateUrl: './OrderView.component.html',
  styleUrls: ['./OrderView.component.css']
})
export class OrderViewComponent implements OnInit{
    userLibraryViews: UserLibraryView[] = [];
    constructor(private UserLibraryViewService: UserLibraryViewService) {}
  ngOnInit(): void {
    this.UserLibraryViewService.getAllUserLibraryView().subscribe((data: UserLibraryView[]) => {
      this.userLibraryViews = data;
    });
  }

}
