import {Component, OnInit} from '@angular/core';
import {WeeklySalesReport} from "../../model/Reports/WeeklySalesReport";
import {ReportsService} from "../../services/reportsService/reports.service";
import {MonthlyGameStatisticsReport} from "../../model/Reports/MonthlyGameStatisticsReport";
import {YearlyGameStatisticsReport} from "../../model/Reports/YearlyGameStatisticsReport";

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit{
  weeklyReport:WeeklySalesReport[]=[];
  monthlyReport:MonthlyGameStatisticsReport[]=[];
  yearlyReport:YearlyGameStatisticsReport[]=[];

  constructor(private ReportsService:ReportsService) { }

  ngOnInit(): void {
    this.ReportsService.getWeekly().subscribe((data:WeeklySalesReport[])=>{
      this.weeklyReport=data;
    });
    this.ReportsService.getMonthly().subscribe((data:MonthlyGameStatisticsReport[])=>{
      this.monthlyReport=data;
    });
    this.ReportsService.getYearly().subscribe((data:YearlyGameStatisticsReport[])=>{
      this.yearlyReport=data;
    });
  }

}
