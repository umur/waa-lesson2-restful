package edu.miu.restful.controller;

import edu.miu.restful.entity.versioningdemo.Name;
import edu.miu.restful.entity.versioningdemo.PersonV1;
import edu.miu.restful.entity.versioningdemo.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
public class PersonResourceController {

    /**
     * Twitter
     * basic way to do versioning, mapping to different URL
     *
     * URI Versioning
     *
     * http://localhost:9999/v1/person
     */
    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    /**
     * Amazon
     * doing versioning using a request parameter.
     *
     * Parameter  versioning
     *
     * http://localhost:9999/person/param?version=1
     */
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }


    /**
     * Microsoft
     * doing versioning using a request header.
     *
     * Header  versioning
     *
     * http://localhost:9999/person/header
     * In the request header set
     * X-API-VERSION=1
     *
     */
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    /**
     * Accept Header / MIME Versioning - using produces
     *
     */
    @GetMapping(value = "/person/produces", produces = "application/mum.edu.cs.app-V1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/produces", produces = "application/mum.edu.cs.app-V2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }



}
