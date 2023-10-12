package com.dxc.springbootxmlreader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "item",consumes = {MediaType.APPLICATION_XML_VALUE})
public class ItemController {
    @Autowired
    ItemRepository itemRepository;
    @GetMapping(value = "/{id}",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public Item getItemById(@PathVariable("id") Long id){
        return new Item(id, "temp-item");
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public Item createItem(@RequestBody Item item){
        return  itemRepository.save(item);

    }
    @DeleteMapping(value = "/id",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public void deleteItem(@PathVariable("id") Long id){
        Item item= itemRepository.findById(id).get();
        itemRepository.delete(item);
    }
}
