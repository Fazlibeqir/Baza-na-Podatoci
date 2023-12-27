import {Component, OnInit} from '@angular/core';
import {UserLibraryView} from '../../model/Views/UserLibraryView';
import {UserLibraryViewService} from '../../services/viewService/UserLibraryView.service';

@Component({
  selector: 'app-pro',
  templateUrl: './UserLibraryView.component.html',
  styleUrls: ['./UserLibraryView.component.css']
})
export class UserLibraryViewComponent implements OnInit{
    userLibraryViews: UserLibraryView[] = [];
    constructor(private UserLibraryViewService: UserLibraryViewService) {}
  ngOnInit(): void {
    this.UserLibraryViewService.getAllUserLibraryView().subscribe((data: UserLibraryView[]) => {
      this.userLibraryViews = data;
    });
  }

}
