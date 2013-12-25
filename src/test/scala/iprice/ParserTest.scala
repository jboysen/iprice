package iprice

import _root_.fetcher.DBAParser
import org.scalatest.FlatSpec
import org.json4s.JsonAST.JValue

object ParserTest {
  val rawInput = """{
   "info":{
        "defaultAdType":"SÃ¦lges",
        "hits":1857,
        "pages":92,
        "filters":[
            {
                "Key":"matrix-model",
                "Name":"Model",
                "Hits":1854,
                "Type":"Matrix",
                "FilterValues":[
                    {
                        "Key":"5",
                        "Name":"5",
                        "Hits":637
                    }
                ],
                "IsSingleSelect":false
            }
        ]
    },
    "ads":[
        {
            "ad-external-id":"1003220139",
            "ad-owner":{
                "ad-ownerid":"4552893",
                "ad-ownertype":1,
                "ad-owner-displayname":"DBA Bruger"
            },
            "creation-date-time":"\/Date(1378591557273+0200)\/",
            "insertion-date-time":"\/Date(1378591557273+0200)\/",
            "expiry-date-time":"\/Date(1383433557273+0100)\/",
            "title":"iPhone 5, 16, sort, ikke",
            "description":"iPhone 5, 16, sort, ikke sim-l\u00E5st, F\u00C5 dage gl iPhone 5 sort 16 GB \n\nK\u00F8bt D 02-09-13 s\u00E5 kun F\u00C5 dage gl.\n\nKun brugt f\u00E5 timer\n\nVirker perfekt \n\nEr som NY og har ingen ridser eller skrammer.\n\nK\u00F8bs og garanti papirer f\u00F8lger med \n\nIngen siml\u00E5s \n\nBytter ikke \n\nS\u00E6lges pga fejlk\u00F8b.\n\nFAST PRIS\n\n\n\n",
            "ad-status":{
                "status-id":1,
                "status-name":"Active"
            },
             "is-call-for-price":false,
             "price":3700.0000,
             "ad-url":{
                "href":"http://www.dba.dk/iphone-5-16-sort-ikke/id-1003220139/"
             },
             "external-url":null,
             "ad-address":{
                "street":null,
                "zip-code":7000,
                "city":"Fredericia",
                "phone":null,
                "phone2":null,
                "longitude":0,
                "latitude":0,
                "email":null,
                "hasEmail":true
             },
             "classification":{
                "category":{
                   "section":{
                      "sectiongroup":{
                         "id":4,
                         "localized-name":"Computer & Telefoni",
                         "hits":0,
                         "priority":5
                      },
                      "id":31,
                      "localized-name":"Mobil og telefoni",
                      "hits":0,
                      "priority":0
                   },
                   "id":101,
                   "localized-name":"Mobiltelefoner og tilbehÃ¸r",
                   "hits":0,
                   "priority":0
                },
                "default-ad-type":2,
                "id":27160,
                "localized-name":"iPhone",
                "hits":0,
                "priority":0
             },
             "pictures":[
                {
                   "rel":"Thumbnail",
                   "link":[
                      {
                         "href":"http://dbastatic.dk/pictures/pictures/4f/50/c853-2050-46a6-ba9a-8c5bb3e6d426.jpg?preset=thumbnail"
                      },
                      {
                         "href":"http://dbastatic.dk/pictures/pictures/f9/26/8e6b-d236-4d6c-acd7-412c962fc811.jpg?preset=thumbnail"
                      }
                   ]
                },
                {
                   "rel":"Normal",
                   "link":[
                      {
                         "href":"http://dbastatic.dk/pictures/pictures/4f/50/c853-2050-46a6-ba9a-8c5bb3e6d426.jpg?preset=normal"
                      },
                      {
                         "href":"http://dbastatic.dk/pictures/pictures/f9/26/8e6b-d236-4d6c-acd7-412c962fc811.jpg?preset=normal"
                      }
                   ]
                },
                {
                   "rel":"Large",
                   "link":[
                      {
                         "href":"http://dbastatic.dk/pictures/pictures/4f/50/c853-2050-46a6-ba9a-8c5bb3e6d426.jpg?preset=large"
                      },
                      {
                         "href":"http://dbastatic.dk/pictures/pictures/f9/26/8e6b-d236-4d6c-acd7-412c962fc811.jpg?preset=large"
                      }
                   ]
                },
                {
                   "rel":"IphoneFullscreen",
                   "link":[
                      {
                         "href":"http://dbastatic.dk/pictures/pictures/4f/50/c853-2050-46a6-ba9a-8c5bb3e6d426.jpg?preset=iphonefullscreen"
                      },
                      {
                         "href":"http://dbastatic.dk/pictures/pictures/f9/26/8e6b-d236-4d6c-acd7-412c962fc811.jpg?preset=iphonefullscreen"
                      }
                   ]
                },
                {
                   "rel":"IphoneSyiPreview",
                   "link":[
                      {
                         "href":"http://dbastatic.dk/pictures/pictures/4f/50/c853-2050-46a6-ba9a-8c5bb3e6d426.jpg?preset=iphonesyipreview"
                      },
                      {
                         "href":"http://dbastatic.dk/pictures/pictures/f9/26/8e6b-d236-4d6c-acd7-412c962fc811.jpg?preset=iphonesyipreview"
                      }
                   ]
                }
             ],
             "matrixdata":[
                {
                   "value":"iPhone 5",
                   "label":"MÃ¦rke"
                },
                {
                   "value":"16",
                   "label":"Hukommelse (GB)"
                },
                {
                   "value":"Sort",
                   "label":"Farve"
                },
                {
                   "value":"Nej",
                   "label":"Sim-lÃ¥st"
                }
             ],
             "ad-type":{
                "type":2
             },
             "show-contact-information-on-map":false,
             "hasQuestionsAndAnswers":true,
             "is-favorite":false,
             "additional-info":{
                "listing-class":"dba-listing",
                "data":{

                }
             },
             "is-user-nemid-validated":true,
             "ad-features":[
                {
                   "id":"2",
                   "name":"QuestionsAndAnswers"
                },
                {
                   "id":"64",
                   "name":"TopListing"
                }
             ]
          },
      ]
  }"""
  val rawInput2 = """{
  "dummy":{
      "defaultAdType":"SÃ¦lges",
      "hits":1857,
      "pages":92,
      "filters":[
    {
      "Key":"matrix-model",
      "Name":"Model",
      "Hits":1854,
      "Type":"Matrix",
      "FilterValues":[
    {
      "Key":"5",
      "Name":"5",
      "Hits":637
    }
    ],
    "IsSingleSelect":false
  }
    ]
  }}"""
}

class ParserTest extends FlatSpec {
  val parser = new DBAParser(ParserTest.rawInput)
  val parsed = parser parse
  val number = parser getTotalPages

  "The result of parse" should "return a parsed JSON object" in {
    assert(parsed.isInstanceOf[JValue])
  }

  it should "return an Int with value 92" in {
    assertResult(92)(number)
  }

  val parser2 = new DBAParser(ParserTest.rawInput2)

  "The result of parser2" should "give an exception because the key is not found" in {
    intercept[RuntimeException]{
      parser2 getTotalPages
    }
  }
}

