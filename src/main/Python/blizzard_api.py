from blizzardapi import BlizzardApi
from pprint import pprint

REGION = "us"
LOCALE = "en_US"

CLIENT_ID = "d49a50fe6379445ab8b8becdd8e765b7"
CLIENT_SECRET = "6n9FfFswhVMfROMso1v5dF0fczMM59fG"
REALM_ID = 3676

api_client = BlizzardApi(CLIENT_ID, CLIENT_SECRET)

"""Get the item class and its related item subclasses """
def getItemClassByID(class_id: int, region=REGION, locale=LOCALE) -> dict:
    item_class_resp = api_client.wow.game_data.get_item_class(region=region, locale=locale, item_class_id=class_id)

    # if the code key is not in the response json, the query was successful and return the 
    # result
    if "code" not in item_class_resp:
        return item_class_resp
    else:
        return None

def getItemSubclassByID(class_id: int, subclass_id: int, region=REGION, locale=LOCALE) -> dict:
    item_subclass_resp = api_client.wow.game_data.get_item_subclass(region=region, locale=locale, item_class_id=class_id, item_subclass_id=subclass_id)

    if "code" not in item_subclass_resp:
        return item_subclass_resp
    else:
        return None

def getItemMediaURLByItemID(item_id: int) -> str:
    media_resp = api_client.wow.game_data.get_item_media(region=REGION, locale=LOCALE, item_id=item_id)

    if "code" not in media_resp:
        return media_resp["assets"][0]["value"]
    else:
        return None

def getCurrentWowTokenPrice(region=REGION, locale=LOCALE) -> dict:
    from datetime import datetime

    timestamp_resp = api_client.wow.game_data.get_token_index(region=region, locale=locale)

    if "code" not in timestamp_resp:
        timestamp = timestamp_resp["last_updated_timestamp"] / 1000
        timestamp_resp["last_updated_timestamp"] = datetime.utcfromtimestamp(timestamp).strftime('%Y-%m-%d %H:%M:%S')
        timestamp_resp["price"] /= 10000
        del timestamp_resp["_links"]
        return timestamp_resp
    else:
        return None

def getActiveAuctions(region=REGION, locale=LOCALE, realm_id=REALM_ID) -> dict:
    auctions_resp = api_client.wow.game_data.get_auctions("us", "en_US", 3676)

    if "code" not in auctions_resp:
        return auctions_resp["auctions"]
    else:
        return None
    

if __name__ == "__main__":
    print(getCurrentWowTokenPrice())