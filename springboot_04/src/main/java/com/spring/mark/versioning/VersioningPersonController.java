package com.spring.mark.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    // (1) URI Versioning - Twitter
    @GetMapping("/v1/person")
    public PersonV1 getFirstURIVersioning() {
        return new PersonV1("Charlie Puth");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondURIVersioning() {
        return new PersonV2(new Name("Charlie", "Puth"));
    }

    // (2) RequestParameter Versioning - Amazon
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstRequestParameterVersioning() {
        return new PersonV1("Charlie Puth");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondRequestParameterVersioning() {
        return new PersonV2(new Name("Charlie", "Puth"));
    }

    // (3) RequestHeader Versioning - Microsoft
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstRequestHeaderVersioning() {
        return new PersonV1("Charlie Puth");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondRequestHeaderVersioning() {
        return new PersonV2(new Name("Charlie", "Puth"));
    }

    // (4) acceptHeader Versioning - GitHub
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstAcceptHeaderVersioning() {
        return new PersonV1("Charlie Puth");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondAcceptHeaderVersioning() {
        return new PersonV2(new Name("Charlie", "Puth"));
    }
}
