import Big from "big.js";

export class WeeklySalesReport{
  username:string;
  weekNumber:Big;
  totalOrders:number;
  totalSales:Big;
  constructor(
    username:string,
    weekNumber:Big,
    totalOrders:number,
    totalSales:Big,
  ){
    this.username=username;
    this.weekNumber=weekNumber;
    this.totalOrders=totalOrders;
    this.totalSales=totalSales;
  }

}
