import { ElementLinks } from "./rest.interfaces/elem_links";

export interface Element {
    id:number;
    name:string;
    price:number;
    images:string;
    _links?:ElementLinks;
}
