#!/usr/bin/env groovy


def params = [ 'active':false,
              'username':'Dangle']


if (params.active) println "I'm going to set the active field to something";


if (params.active != null)  println "I'ts not null";
