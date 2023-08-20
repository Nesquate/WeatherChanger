# 天氣變換券

這是一個 Minecraft Fabric mod，建立了三個物品 (放晴券、喚雨券、喚雷券) 供玩家利用物品變更天氣。

該模組目前僅供 [美代子伺服器](https://discord.gg/mSdMqEAAFW) 使用。

## 目前設計
參考了 `WeatherCommand` 類別進行三個券的設計：

- 放晴券: 就是放晴，沒有其他用途
- 喚雨券: 下雨，會下五分鐘 (6000 ticks)
- 喚雷券: 雷雨，會下三分鐘 (3600 ticks)

之後有可能隨時會調整。

使用 [Polymer](https://github.com/Patbox/polymer) 產生只要伺服器端安裝就可以讓玩家使用的物品，並使用 [Server Translation API](https://github.com/NucleoidMC/Server-Translations) 讓模組本身可以翻譯。

## 授權
目前採 GPL 3.0。

