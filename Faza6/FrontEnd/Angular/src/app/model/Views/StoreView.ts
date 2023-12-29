export class StoreView{
    id_game:number;
    title:string;
    genre:string;
    image:string;
    publisher_name:string;
    website:string;
    platform_name:string;
    manufacturer:string;
    constructor(
      id_game:number,
      title:string,
      genre:string,
      image:string,
      publisher_name:string,
      website:string,
      platform_name:string,
      manufacturer:string,
    ){
        this.id_game=id_game;
        this.title=title;
        this.genre=genre;
        this.image=image;
        this.publisher_name=publisher_name;
        this.website=website;
        this.platform_name=platform_name;
        this.manufacturer=manufacturer;
    }
}
