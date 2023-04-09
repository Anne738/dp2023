import { Element } from "../element";
import { Page } from "./page";
import { RootLinks } from "./root_links";

export interface Http {
    _embedded: {
      elements: Element[];
      watches: Element[];
    };
    _links: RootLinks;
    page: Page;
  }