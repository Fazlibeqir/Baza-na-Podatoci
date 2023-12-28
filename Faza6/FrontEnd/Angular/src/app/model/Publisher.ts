
export class Publisher{
  id_publisher:number;
    name:string;
    website:string;
    country:string;
    constructor(id_publisher:number,name:string,
                website:string,country:string){
        this.id_publisher=id_publisher;
        this.name=name;
        this.website=website;
        this.country=country;
    }
}
