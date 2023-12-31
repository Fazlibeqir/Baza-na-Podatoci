import Big from "big.js";

export class Promotion{
  id_promotion:number;
  title:string;
  startDate:Date;
  endDate:Date;
  discountPercentage:Big;
  constructor(id_promotion: number, title: string, startDate: Date, endDate: Date, discountPercentage: Big) {
    this.id_promotion = id_promotion;
    this.title = title;
    this.startDate = startDate;
    this.endDate = endDate;
    this.discountPercentage = discountPercentage;
  }
}
