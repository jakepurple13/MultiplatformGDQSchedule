package com.programmersbox.common

internal val gdqSource = """
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Games Done Quick</title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="/static/res/css/main.css" />
    <script src="/static/res/js/mains2.min.js"></script>
    <link rel="shortcut icon" href="/static/res/img/favicon/favicon.ico">
    <link rel="apple-touch-icon" sizes="57x57" href="/static/res/img/favicon/apple-touch-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/static/res/img/favicon/apple-touch-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="72x72" href="/static/res/img/favicon/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="144x144" href="/static/res/img/favicon/apple-touch-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="60x60" href="/static/res/img/favicon/apple-touch-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="120x120" href="/static/res/img/favicon/apple-touch-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="76x76" href="/static/res/img/favicon/apple-touch-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="152x152" href="/static/res/img/favicon/apple-touch-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="/static/res/img/favicon/apple-touch-icon-180x180.png">
    <link rel="icon" type="image/png" href="/static/res/img/favicon/favicon-192x192.png" sizes="192x192">
    <link rel="icon" type="image/png" href="/static/res/img/favicon/favicon-160x160.png" sizes="160x160">
    <link rel="icon" type="image/png" href="/static/res/img/favicon/favicon-96x96.png" sizes="96x96">
    <link rel="icon" type="image/png" href="/static/res/img/favicon/favicon-16x16.png" sizes="16x16">
    <link rel="icon" type="image/png" href="/static/res/img/favicon/favicon-32x32.png" sizes="32x32">
    <meta name="msapplication-TileColor" content="#2b5797">
    <meta name="msapplication-TileImage" content="/static/res/img/favicon/mstile-144x144.png">
    <meta name="msapplication-config" content="/static/res/img/favicon/browserconfig.xml">
    </head>
    <body>
    <div id="battlescene" style="display: none;">
    <p id="inputscene" style="color: #aaff33; font-family: Arial, sans-serif; font-weight: 500; font-size: 56px; position: absolute; top: 6%; right: 10%; text-shadow: 0 0 5px #22ff22;">
    Input 1 </p>
    <a href="#" title="Click to return whence you came, Harrier." onclick="location.reload();">
    <video id="battlevideo" preload="none" loop style="position: fixed; height: 100%; width: 100%; right: 0; left: 0; bottom: 0; margin-left: auto; margin-right: auto;">
    <source id="battlesource1" type="video/webm" src="/static/res/video/harrierverylow.webm">
    <source src="/static/res/video/harrierverylow.mp4" type="video/mp4">
    </video>
    </a>
    </div>
    <div id="scene">
    <div id="white-bg">
    <nav id="top" class="navbar navbar-default navbar-static-top navbar-inverse" role="navigation">
    <div class="container">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    </button> <a class="navbar-brand visible-xs-inline" href="#" onclick="window.history.go(-1); return false;"><i class="fa fa-chevron-left"></i></a> <a class="navbar-brand" href="/"><img src="/static/res/img/gdqlogo.png" style="height: 100%" alt="Games Done Quick" /></a>
     </div>
    <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
    <li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Event Info
    <span class="caret"></span></a>
    <ul class="dropdown-menu" role="menu">
    <li><a href="https://gamesdonequick.com/prize-guide"><i class="fa fa-gift fa-fw"></i> Prize
    Submissions Guide</a></li>
    <li><a href="https://gamesdonequick.com/rules"><i class="fa fa-gavel fa-fw"></i> Event/Broadcast
    Rules</a></li>
    <li><a href="https://gamesdonequick.com/volunteer/faq"><i class="fa fa-question fa-fw"></i>
    Volunteering FAQ</a></li>
    <li><a href="https://gamesdonequick.com/submission-guide"><i class="fa fa-book fa-fw"></i> Game
    Submission Guide</a></li>
    <li class="divider"></li>
    <li><a href="https://gamesdonequick.com/submission/all"><i class="fa fa-gamepad fa-fw"></i> AGDQ2023
    Game Submissions</a></li>
    <li><a href="https://gamesdonequick.com/schedule"><i class="fa fa-clock-o fa-fw"></i> AGDQ2023 Schedule</a></li>
    <li class="divider"></li>
    <li><a href="https://gamesdonequick.com/framefatales"><i class="fa fa-gamepad fa-fw"></i> Frame
    Fatales Information</a></li>
    </ul>
    </li>
    <li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Community Info <span class="caret"></span></a>
    <ul class="dropdown-menu" role="menu">
    <li role="presentation" class="dropdown-header">Games Done Quick</li>
    <li><a href="https://photos.gamesdonequick.com"><i class="fa fa-camera fa-fw"></i> Event
    Photos</a></li>
    <li><a href="https://twitch.tv/gamesdonequick"><i class="fa fa-twitch fa-fw"></i> Twitch
    Channel</a></li>
    <li><a href="https://twitter.com/GamesDoneQuick"><i class="fa fa-twitter fa-fw"></i>
    Twitter</a></li>
    <li role="presentation" class="dropdown-header">Speedrunning Guides</li>
    <li><a href="/mod-guide"><i class="fa fa-gavel fa-fw"></i> Guide to Automated Moderation</a>
    </li>
    <li class="divider"></li>
    <li role="presentation" class="dropdown-header">Speedrunning Communities</li>
    <li><a href="http://speeddemosarchive.com"><i class="fa fa-archive fa-fw"></i> Speed
    Demos Archive</a></li>
    <li><a href="http://speedrunslive.com"><i class="fa fa-video-camera fa-fw"></i> Speed
    Runs Live</a></li>
    <li><a href="http://speedrun.com"><i class="fa fa-clock-o fa-fw"></i> Speedrun.com</a>
    </li>
    </ul>
     </li>
    <li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">About Us <span class="caret"></span></a>
    <ul class="dropdown-menu" role="menu">
    <li><a href="https://gamesdonequick.com/privacy"><i class="fa fa-eye-slash fa-fw"></i> Privacy
    Policy</a></li>
    <li><a href="https://gamesdonequick.com/jobs"><i class="fa fa-group fa-fw"></i> Jobs at GDQ</a>
    </li>
    <li><a href="https://gamesdonequick.com/contact"><i class="fa fa-pencil fa-fw"></i> Contact Us</a>
    </li>
    </ul>
    </li>
    <li>
    <a href="https://discord.gg/gamesdonequick"><i class="fa fa-fw fa-comments" aria-hidden="true"></i> Discord</a>
    </li>
    <li>
    <a href="https://www.youtube.com/user/gamesdonequick/playlists"><i class="fa fa-fw fa-youtube-play" aria-hidden="true"></i> VODS</a>
    </li>
    <li>
    <a href="/hotfix"><i class="fa fa-fw fa-bolt" aria-hidden="true"></i> HOTFIX</a>
    </li>
    </ul>
    <a href="https://gamesdonequick.com/auth/login" role="button" class="btn btn-primary btn-sm navbar-btn navbar-right extra-button-space">Login</a>
    <a href="https://gamesdonequick.com/auth/register" role="button" class="btn btn-danger btn-sm navbar-btn navbar-right extra-button-space">Register</a> </div>
    </div>
    </nav>
    <div class="container">
    <br />
    </div>
    <div class="container text-center">
    <div class="fa-stack center-block medium-icon-red fa-5x">
    <i class="fa fa-circle fa-stack-2x"></i> <i class="fa fa-clock-o fa-stack-1x fa-inverse"></i>
    </div>
    <h1 class="text-gdq-red extra-spacing">Awesome Games Done Quick 2023 Online Schedule</h1>
    <p>Looking for the upcoming <a href="/schedule/42">Frost Fatales 2023 schedule</a>?</p>
    <h4 class="text-gdq-black well ">All start and end times below are converted to your local time<span id="offset-detected"></span>.</h4>
    </div>
    <p class="text-center"><a href="#current" class="btn btn-primary extra-button-space">Jump to Current Run</a></p>
    <table id="runTable" class="table table-condensed">
    <thead>
    <tr class="day-split">
    <td>Time &amp; Length</td>
    <td>Run</td>
    <td>Runners &amp; <i class="fa fa-microphone"></i> Host</td>
    <td class="visible-lg">Setup&nbsp;Length</td>
    </tr>
    </thead>
    <tbody>
    <tr>
    <td class="start-time text-right">2023-01-08T16:30:00Z</td>
    <td>Pre-Show</td>
    <td>Interview Crew</td>
    <td rowspan="2" class="visible-lg text-center"> </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:27:00 </td>
    <td>We&#039;re Back &mdash; GDQ Studio</td>
    <td><i class="fa fa-microphone"></i> Xenadir</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-08T16:57:00Z</td>
    <td>Splatoon 3</td>
    <td>LonTr0</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:44:27 </td>
     </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:56:33 </td>
    <td>Any% &mdash; Switch</td>
    <td><i class="fa fa-microphone"></i> Xenadir</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-08T18:38:00Z</td>
    <td>The Legend of Zelda: Breath of the Wild</td>
    <td>Player 5</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:18:04 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:29:56 </td>
    <td>Any% &mdash; Switch</td>
    <td><i class="fa fa-microphone"></i> Xenadir</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-08T19:26:00Z</td>
    <td>Crash Bandicoot: N. Sane Trilogy</td>
    <td>Murcaz</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:20:26 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:44:34 </td>
    <td>Crash 3 Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Xenadir</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-08T20:31:00Z</td>
    <td>Mirror&#039;s Edge Catalyst</td>
    <td>CodeNameMeteor</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:19:59 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:53:01 </td>
    <td>NG+ &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> cartridgeblowers</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-08T21:44:00Z</td>
    <td>Castlevania: Symphony of the Night</td>
    <td>Dr4gonBlitz</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:27:20 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:32:40 </td>
    <td>All Bosses &mdash; Xbox 360</td>
    <td><i class="fa fa-microphone"></i> cartridgeblowers</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-08T22:44:00Z</td>
    <td>Borderlands: Game of the Year Enhanced</td>
    <td>zzrules21</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:24:11 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:23:49 </td>
    <td>Any% Unrestricted &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> cartridgeblowers</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T00:32:00Z</td>
    <td>BONUS GAME 1 - Cuphead</td>
    <td>Jason2890</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:35:41 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:12:19 </td>
    <td>300% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> ateatree</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T02:20:00Z</td>
    <td>Donkey Kong Country 3</td>
    <td>Bluepen49, laff____, Shaaf</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:13:10 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:46:50 </td>
    <td>DKC3 Any% Race &mdash; SNES</td>
    <td><i class="fa fa-microphone"></i> ateatree</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T03:20:00Z</td>
    <td>Daily Recap - Sunday</td>
    <td>Interview Crew</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:01:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:12:00 </td>
    <td>Recap% &mdash; Live</td>
    <td><i class="fa fa-microphone"></i> ateatree</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T03:33:00Z</td>
    <td>Metal Gear Solid V: Ground Zeroes</td>
    <td>JosephJoestar316</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:24:58 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:32:02 </td>
    <td>Perfect Stealth/No Kills NG+ &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> ateatree</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T04:30:00Z</td>
    <td>Pok&eacute;mon Mystery Dungeon: Explorers of Sky</td>
    <td>EpicYoshiMaster</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:15:16 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:46:44 </td>
    <td>Randomizer 10 Dungeon Blitz &mdash; DS</td>
    <td><i class="fa fa-microphone"></i> Char_bunny</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T05:32:00Z</td>
    <td>Vampire: The Masquerade - Bloodlines</td>
    <td>Vysetra</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:14:10 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:37:50 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Char_bunny</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T06:24:00Z</td>
    <td>Tony Hawk&#039;s Pro Skater 4</td>
    <td>Nase</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:20:55 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:38:05 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Char_bunny</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T07:23:00Z</td>
    <td>SSX (2000)</td>
    <td>junior</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:18:04 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:19:56 </td>
    <td>All Race Golds (Single Event) &mdash; PS2</td>
    <td><i class="fa fa-microphone"></i> Char_bunny</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T08:01:00Z</td>
    <td>Psi-Ops: The Mindgate Conspiracy</td>
    <td>Kainalo</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:09:54 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:30:40 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> THEKyleThomas</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T08:41:34Z</td>
    <td>Dust: An Elysian Tail</td>
    <td>AggytheAron</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:26 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:24:03 </td>
    <td>Any% Warps &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> THEKyleThomas</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T09:16:03Z</td>
    <td>Ax Battler: A Legend of Golden Axe</td>
    <td>sharif</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:59 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:29:23 </td>
    <td>100% &mdash; Game Gear</td>
    <td><i class="fa fa-microphone"></i> THEKyleThomas</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T09:56:25Z</td>
    <td>Cyber Hook</td>
    <td>squeali0</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:25:58 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:32:22 </td>
    <td>Full Game Marathon &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> THEKyleThomas</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T10:54:45Z</td>
    <td>Gungrave</td>
    <td>DECosmic</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:17:01 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:30:29 </td>
    <td>Any% &mdash; PS2</td>
    <td><i class="fa fa-microphone"></i> Bobby Blackwolf</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T11:42:15Z</td>
    <td>Armored Core: Project Phantasma</td>
    <td>pmcTRILOGY</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:05:10 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:35:35 </td>
    <td>Any% &mdash; PS</td>
    <td><i class="fa fa-microphone"></i> Bobby Blackwolf</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T12:23:00Z</td>
    <td>Bomberman 64: the Second Attack</td>
    <td>EiP</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:07:52 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:30:08 </td>
    <td>Any% &mdash; N64</td>
    <td><i class="fa fa-microphone"></i> Bobby Blackwolf</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T13:01:00Z</td>
    <td>Onimusha 2: Samurai&#039;s Destiny</td>
    <td>Woadyb</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:19:50 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:15:10 </td>
    <td>Any% Easy No Ultimate &mdash; PS2</td>
    <td><i class="fa fa-microphone"></i> Bobby Blackwolf</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T14:36:00Z</td>
    <td>Superliminal</td>
    <td>Ozmourn</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:16:07 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:30:53 </td>
    <td>All Collectables &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Lanaruse</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T15:23:00Z</td>
    <td>Skate</td>
    <td>SupaScared</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:26:56 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:45:04 </td>
    <td>X Games% &mdash; Xbox Series S</td>
    <td><i class="fa fa-microphone"></i> Lanaruse</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T16:35:00Z</td>
    <td>Shovel Knight Dig</td>
    <td>davidtki, Luukie13</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:21:40 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:13:20 </td>
    <td>Any% Race &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Lanaruse</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T17:10:00Z</td>
    <td>CULTIC</td>
    <td>Kaos_Wulf</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:25:04 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:15:56 </td>
    <td>Any% Inbounds &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Lanaruse</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T17:51:00Z</td>
    <td>Yakuza Kiwami</td>
    <td>BigNoNo</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:33:46 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:35:14 </td>
    <td>New Game+ &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Shado_Temple</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T20:00:00Z</td>
    <td>Teenage Mutant Ninja Turtles: Shredder&#039;s Revenge</td>
    <td>GeneralAndrews, Dospostmann, Benja, Paul-Knives</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:22:37 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:00:23 </td>
    <td>Co-op 2v2 Any% Arcade Chill Race &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Shado_Temple</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-09T21:23:00Z</td>
    <td>Marvel&#039;s Spider-Man: Miles Morales</td>
    <td>Pessilist</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:21:18 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 2:31:42 </td>
    <td>Any% &mdash; PS5</td>
    <td><i class="fa fa-microphone"></i> briesbe</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T00:16:00Z</td>
    <td>BONUS GAME 2 - Portal</td>
    <td>Msushi</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:17:30 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:22:30 </td>
    <td>Airboat% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> briesbe</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T00:56:00Z</td>
    <td>BioShock</td>
    <td>bloodthunder</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:07 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:35:53 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> briesbe</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T01:42:00Z</td>
    <td>Fallout 3</td>
    <td>BananaPegasus</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:09:19 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:18:41 </td>
    <td>All Quest &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> musical_daredevil</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T03:10:00Z</td>
    <td>Daily Recap - Monday</td>
    <td>Interview Crew</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:01:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:10:00 </td>
    <td>Recap% &mdash; Live</td>
    <td><i class="fa fa-microphone"></i> musical_daredevil</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T03:21:00Z</td>
    <td>Hitman: Blood Money</td>
    <td>Threeballer</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:18:42 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:32:18 </td>
    <td>PRO/SA &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Nichole Goodnight</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T04:12:00Z</td>
    <td>Fable Anniversary</td>
    <td>SeraVenza</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:16:45 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:14:15 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Nichole Goodnight</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T05:43:00Z</td>
    <td>Ape Escape 2</td>
    <td>Liquid Squid</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:04 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:55:56 </td>
    <td>Any% &mdash; PS3</td>
    <td><i class="fa fa-microphone"></i> Nichole Goodnight</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T06:49:00Z</td>
    <td>Frogun</td>
    <td>Traitor</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:15:34 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:46:26 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Nichole Goodnight</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T07:51:00Z</td>
    <td>MediEvil: Resurrection</td>
    <td>desa</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:11:13 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:37:49 </td>
    <td>Any% &mdash; PSP</td>
    <td><i class="fa fa-microphone"></i> SporadicErratic</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T08:40:02Z</td>
    <td>Blade II</td>
    <td>Mattmatt</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:12:10 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:46:45 </td>
    <td>Any% NG+ &mdash; Xbox</td>
    <td><i class="fa fa-microphone"></i> SporadicErratic</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T09:38:57Z</td>
    <td>Goat Simulator</td>
    <td>Riekelt</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:30:47 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:16:26 </td>
    <td>All Trophies [Base Game] &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> SporadicErratic</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T10:26:10Z</td>
    <td>Illbleed</td>
    <td>Punchy</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:14:12 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:19:38 </td>
    <td>Any% &mdash; Dreamcast</td>
    <td><i class="fa fa-microphone"></i> SporadicErratic</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T12:00:00Z</td>
    <td>Wavetale</td>
    <td>Glint</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:07:42 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:57:18 </td>
    <td>Any% No Major Skips &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> attyjoe</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T13:05:00Z</td>
    <td>Burnout Paradise Remastered</td>
    <td>sawtoooooth</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:18:55 </td>
    </tr>
    <tr class="second-row ">
     <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:26:05 </td>
    <td>Big Surf Island Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Argick</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T13:50:00Z</td>
    <td>ASTRAL CHAIN</td>
    <td>Ratyu</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:19:22 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 2:34:38 </td>
    <td>Any%(No Abilities) &mdash; Switch</td>
    <td><i class="fa fa-microphone"></i> Argick</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T16:44:00Z</td>
    <td>Castlevania: Harmony of Despair</td>
    <td>KeynNaka</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:20:16 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:28:44 </td>
    <td>Solo All character NG+ &mdash; XBOX 360</td>
    <td><i class="fa fa-microphone"></i> THEKyleThomas</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T17:33:00Z</td>
    <td>Castlevania: Aria of Sorrow</td>
    <td>JupiterClimb, Chewy4u</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:28:44 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:14:16 </td>
    <td>Any% No 0HP (Standard) &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> THEKyleThomas</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T18:16:00Z</td>
    <td>Fashion Police Squad</td>
    <td>danejerus</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:25:44 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:46:16 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> THEKyleThomas</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T19:28:00Z</td>
    <td>Transistor</td>
    <td>Kass</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:32:02 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:44:58 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> THEKyleThomas</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-10T20:45:00Z</td>
    <td>Super Mario Galaxy 2</td>
    <td>SuperViperT302, HardcoreGaming, ImJhay, MutantsAbyss</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:22:04 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 3:03:56 </td>
    <td>Any% Race &mdash; Wii U VC</td>
    <td><i class="fa fa-microphone"></i> HeyThereImDad</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T00:11:00Z</td>
    <td>Jak II</td>
    <td>rRubiks</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:17:09 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:03:51 </td>
    <td>Any% &mdash; PS2</td>
    <td><i class="fa fa-microphone"></i> cartridgeblowers</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T01:32:00Z</td>
    <td>Outer Wilds</td>
    <td>ptminsker</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:24:59 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:26:01 </td>
    <td>Stranger 100% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> cartridgeblowers</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T02:23:00Z</td>
    <td>Ratchet &amp; Clank: Up Your Arsenal</td>
    <td>Scottobozo</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:25:01 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:09:59 </td>
    <td>All Titanium Bolts &mdash; PS3</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T03:58:00Z</td>
    <td>BONUS GAME 3 - Resident Evil Village: Shadow of Rose</td>
    <td>7rayD</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:07:28 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:47:32 </td>
    <td>Hardcore &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T04:53:00Z</td>
    <td>Daily Recap - Tuesday</td>
    <td>Interview Crew</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:02:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:15:00 </td>
    <td>Recap% &mdash; Live</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T05:10:00Z</td>
    <td>Resident Evil 7</td>
    <td>Maxylobes</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:22:32 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:20:28 </td>
    <td>End of Zoe Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T05:53:00Z</td>
    <td>Poppy Playtime: Chapter 2</td>
    <td>Nerd_Squared</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:21 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:24:39 </td>
    <td>100% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T06:28:00Z</td>
    <td>Dead Space 3</td>
    <td>sharkhat87, SergeantRadish</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:39:11 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:59:02 </td>
    <td>Any% Coop &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Kungfufruitcup</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T09:06:13Z</td>
    <td>Cryostasis</td>
    <td>shmumbler</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:06:18 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:34:27 </td>
    <td>any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Kungfufruitcup</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T09:46:58Z</td>
    <td>Mortal Kombat: Shaolin Monks</td>
    <td>Elfinout</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:09:08 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:17:57 </td>
    <td>Any% &mdash; PS2</td>
    <td><i class="fa fa-microphone"></i> Kungfufruitcup</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T10:14:03Z</td>
    <td>FEZ</td>
    <td>thearst3rd</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:09:20 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:26:11 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Prolix</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T10:49:34Z</td>
    <td>Sutte Hakkun</td>
    <td>junkyard_dave</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:13:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:12:33 </td>
    <td>50 Levels &mdash; GBC</td>
    <td><i class="fa fa-microphone"></i> Prolix</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T11:15:07Z</td>
    <td>Vampire Night</td>
    <td>Boyks</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:06:38 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:38:15 </td>
    <td>Arcade Medium &mdash; PS2</td>
    <td><i class="fa fa-microphone"></i> Prolix</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T12:00:00Z</td>
    <td>Nightmare of Decay</td>
    <td>Gnydsmelt</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:21:23 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:19:37 </td>
    <td>Any% Normal &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Prolix</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T12:41:00Z</td>
    <td>Final Fantasy VII</td>
    <td>Zheal</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:39:18 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 6:55:42 </td>
    <td>any% No Slots &mdash; PS</td>
    <td><i class="fa fa-microphone"></i> Brutal_Melo, SporadicErratic</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T20:16:00Z</td>
    <td>Stardew Valley</td>
    <td>blackheartwings, theValiantSun</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:21:15 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:35:45 </td>
    <td>Seeded Crafts Room - Glitchless Race &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Skybilz</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T21:13:00Z</td>
    <td>Sonic Unleashed</td>
    <td>Speck</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:18:23 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:22:37 </td>
    <td>All Day Stages &mdash; Wii</td>
    <td><i class="fa fa-microphone"></i> Skybilz</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T21:54:00Z</td>
    <td>Sonic Colors: Ultimate</td>
    <td>thebluemania, Subbaro, Nyu</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:25:15 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:48:45 </td>
    <td>Egg Shuttle Race &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Skybilz</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-11T23:08:00Z</td>
    <td>Sonic Advance 2</td>
    <td>Kirbymastah</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:23:57 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:28:03 </td>
    <td>Character Bidwar &mdash; GBA</td>
    <td><i class="fa fa-microphone"></i> Skybilz</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T00:00:00Z</td>
    <td>Pok&eacute;mon Yellow</td>
    <td>pokeguy</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:21:36 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 2:01:24 </td>
    <td>Any% Glitchless &mdash; GB</td>
    <td><i class="fa fa-microphone"></i> Lanaruse</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T02:23:00Z</td>
    <td>The Legend of Zelda: Ocarina of Time 3D</td>
    <td>benstephens56</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:16:13 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:30:47 </td>
    <td>Any% &mdash; 3DS</td>
    <td><i class="fa fa-microphone"></i> Lanaruse</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T03:10:00Z</td>
    <td>BONUS GAME 4 - Stray</td>
    <td>Erims</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:10 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:49:50 </td>
    <td>Any% Unrestricted &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Konception</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T04:10:00Z</td>
    <td>Daily Recap - Wednesday</td>
    <td>Interview Crew</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:02:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:15:00 </td>
    <td>Recap% &mdash; Live</td>
    <td><i class="fa fa-microphone"></i> Konception</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T04:27:00Z</td>
    <td>Spyro 2: Ripto&#039;s Rage!</td>
    <td>slvr__, zacharylawrence, Spudlyman, Wed</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:31:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:32:00 </td>
    <td>2v2 Lockout Bingo &mdash; PS2</td>
    <td><i class="fa fa-microphone"></i> Konception</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T05:30:00Z</td>
    <td>Neon White</td>
    <td>Blaidan</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:28:24 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:37:36 </td>
    <td>White&#039;s Heaven Rush &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Konception</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T06:36:00Z</td>
    <td>Yo! Noid 2: Game of a Year Edition</td>
    <td>rythin</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:09:24 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:14:37 </td>
    <td>No Major Skips &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Konception</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T07:00:01Z</td>
    <td>Kirby Star Allies</td>
    <td>Mr_Shasta</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:23:37 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:35:22 </td>
    <td>Guest Star ???? Star Allies Go! Mage Sisters &mdash; Switch</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T07:59:00Z</td>
    <td>Pac-Man 2: The New Adventures</td>
    <td>PARTY MAN X</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:24:54 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:24:19 </td>
    <td>any% &mdash; SNES</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T08:48:13Z</td>
    <td>Yolanda: The Ultimate Challenge</td>
    <td>FlannelKat</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:12:10 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:09:30 </td>
    <td>Wimp% &mdash; Amiga</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T09:09:53Z</td>
    <td>Lizard Lady vs the Cats</td>
    <td>Asuka424</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:41 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:04:12 </td>
    <td>Any% &mdash; PS5</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T09:24:46Z</td>
    <td>Office Race</td>
    <td>BystanderTim</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:09:02 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:24:27 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T09:58:15Z</td>
    <td>Salamander County Public Television</td>
    <td>teddyras</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:39 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:21:32 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> AnEternalEnigma</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T10:30:26Z</td>
    <td>Battle of the Eras</td>
    <td>corndan</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:07:08 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:08:20 </td>
    <td>any% Shadowsnake &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Nichole Goodnight</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T10:45:54Z</td>
    <td>Morodashi Sumo</td>
    <td>teddyras</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:31 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:24:45 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Nichole Goodnight</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T11:21:10Z</td>
    <td>Dokkaebi-ga Ganda</td>
    <td>dowolf</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:09:36 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:19:29 </td>
    <td>any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Nichole Goodnight</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T11:50:15Z</td>
    <td>I&#039;m going to die if I don&#039;t eat sushi!</td>
    <td>Bullets</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:08:51 </td>
    </tr>
     <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:21:54 </td>
    <td>Any% Easy &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Nichole Goodnight</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T12:21:00Z</td>
    <td>Sonic Blast</td>
    <td>Hibnotix, S-TWO</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:54 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:14:06 </td>
    <td>Sonic vs Knuckles - Beat the Game Race &mdash; Game Gear</td>
    <td><i class="fa fa-microphone"></i> Nichole Goodnight</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T12:46:00Z</td>
    <td>Bad Guys At School</td>
    <td>Sadlybadlyy</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:07:20 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:23:40 </td>
    <td>All Missions &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Bobby Blackwolf</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T13:17:00Z</td>
    <td>Steven Seagal Is: The Final Option (Prototype)</td>
    <td>Crak Atak</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:18:16 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:21:44 </td>
    <td>any% 9 exits &mdash; SNES</td>
    <td><i class="fa fa-microphone"></i> Bobby Blackwolf</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T13:57:00Z</td>
    <td>Mega Man ZX</td>
    <td>Amesiyo</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:20:09 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:50:51 </td>
    <td>Any% Normal &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Bobby Blackwolf</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T15:08:00Z</td>
    <td>The World Ends with You: Final Remix</td>
    <td>Kuro*</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:22:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 2:53:44 </td>
    <td>Any% Normal &mdash; Switch</td>
    <td><i class="fa fa-microphone"></i> Mr. Game and Shout</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T18:23:44Z</td>
    <td>Boomerang X</td>
    <td>Evandar</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:19:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:22:21 </td>
    <td>Any% NG &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Mr. Game and Shout</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T19:05:05Z</td>
    <td>Metal Slug</td>
    <td>ChairGTables</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:20:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:12:40 </td>
    <td>Medium - Steam &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> iggyzig</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T19:37:45Z</td>
    <td>Star Wars: Jedi Knight - Mysteries of the Sith</td>
    <td>Alnak</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:25:22 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:25:53 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> iggyzig</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T20:29:00Z</td>
    <td>BS Legend of Zelda</td>
    <td>vanni_van, Iceblue</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:22:37 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:36:23 </td>
    <td>100% Race &mdash; SNES</td>
    <td><i class="fa fa-microphone"></i> iggyzig</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-12T21:28:00Z</td>
    <td>The Legend of Zelda: Skyward Sword</td>
    <td>gymnast86</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:18:17 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 3:07:43 </td>
    <td>All Dungeons &mdash; Wii</td>
    <td><i class="fa fa-microphone"></i> PippyInATopHat</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T00:54:00Z</td>
    <td>Puyo Puyo Fever 2</td>
    <td>Peas</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:24:06 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:19:54 </td>
    <td>HaraHara Any% (Normal) &mdash; PS2</td>
    <td><i class="fa fa-microphone"></i> RUBIEHART</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T01:38:00Z</td>
    <td>BONUS GAME 5 - Mario Kart 8 Deluxe</td>
    <td>Peas</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:09:02 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:56:58 </td>
    <td>150cc DLC 16 Tracks (No Items) &mdash; Switch</td>
    <td><i class="fa fa-microphone"></i> RUBIEHART</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T02:44:00Z</td>
    <td>Daily Recap - Thursday</td>
    <td>Interview Crew</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:12:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:12:00 </td>
    <td>Recap% &mdash; Live</td>
    <td><i class="fa fa-microphone"></i> RUBIEHART</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T03:08:00Z</td>
    <td>The Simpsons: Hit &amp; Run</td>
    <td>LiquidWiFi</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:27:50 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:25:10 </td>
    <td>All Story Missions &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> frozenflygone</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T05:01:00Z</td>
    <td>Metal Gear Solid 3: Snake Eater</td>
    <td>ApacheSmash, Vermillion</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:23:30 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:15:30 </td>
    <td>European Extreme Race &mdash; Xbox Series S</td>
    <td><i class="fa fa-microphone"></i> ateatree</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T06:40:00Z</td>
    <td>PowerWash Simulator</td>
    <td>Amyrlinn, Bullets, Biglaw, Enigma Requiem, AngelicKnight, Acadiel</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:18:29 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:33:31 </td>
    <td>6 Players, All Vehicles, No Soap &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> ateatree</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T07:32:00Z</td>
    <td>Celeste Custom Maps</td>
    <td>Comet625</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:11:05 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:21:17 </td>
    <td>Into the Jungle - Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Xenadir</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T08:04:22Z</td>
    <td>Worms Armageddon</td>
    <td>RuffledBricks</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:18:34 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:11:12 </td>
    <td>All Missions Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Xenadir</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T09:34:08Z</td>
    <td>Kirby Air Ride</td>
    <td>1davidj</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:40 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:21:02 </td>
    <td>All Tracks No Duplicate Rides &mdash; Wii</td>
    <td><i class="fa fa-microphone"></i> Xenadir</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T10:05:50Z</td>
    <td>Jackal</td>
    <td>Toad22484, anthole</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:17:27 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:09:01 </td>
    <td>Any% (2-Player) &mdash; NES</td>
    <td><i class="fa fa-microphone"></i> Xenadir</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T10:32:18Z</td>
    <td>Mickey Mousecapade</td>
    <td>BluntBunny</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:11:04 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:08:23 </td>
    <td>Any% &mdash; NES</td>
    <td><i class="fa fa-microphone"></i> Prolix</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T10:51:45Z</td>
    <td>Chip &#039;n Dale Rescue Rangers</td>
    <td>Tecate</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:06:25 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:13:25 </td>
    <td>Any% &mdash; NES</td>
    <td><i class="fa fa-microphone"></i> Prolix</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T11:11:35Z</td>
    <td>Marble Blast Ultra</td>
    <td>thearst3rd</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:08 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:33:58 </td>
    <td>All Levels &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Prolix</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T11:55:41Z</td>
    <td>Beautiful Katamari</td>
    <td>Harutomo</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:07:03 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:27:16 </td>
    <td>Any% &mdash; Xbox 360</td>
    <td><i class="fa fa-microphone"></i> Prolix</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T12:30:00Z</td>
    <td>PS5 Simulator</td>
    <td>Swordfish4649</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:26 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:06:34 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Prolix</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T12:47:00Z</td>
    <td>ElecHead</td>
    <td>Uncle Slam</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:12:36 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:16:24 </td>
    <td>Alternate End &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Argick</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T13:16:00Z</td>
    <td>Gunstar Heroes</td>
    <td>TapatioJ, Bag the Tea</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:08:22 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:42:38 </td>
    <td>Any% Normal Co-op &mdash; Switch</td>
    <td><i class="fa fa-microphone"></i> Argick</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T14:07:00Z</td>
    <td>Hook</td>
    <td>LivelyRaccoon</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:13:09 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:14:51 </td>
    <td>Any% &mdash; SNES</td>
    <td><i class="fa fa-microphone"></i> Argick</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T14:35:00Z</td>
    <td>Kirby&#039;s Adventure</td>
    <td>Darksol188</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:12:50 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:41:10 </td>
    <td>Any% No Stone Glitch &mdash; Wii U</td>
    <td><i class="fa fa-microphone"></i> Argick</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T15:29:00Z</td>
    <td>Haiku, the Robot</td>
    <td>Quacksilver</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:12:22 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:22:38 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Char_bunny</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T16:04:00Z</td>
    <td>Tony Hawk&#039;s Pro Skater HD</td>
    <td>Biglaw</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:32:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:18:24 </td>
    <td>All Goals &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Char_bunny</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T16:54:24Z</td>
    <td>Metroid Prime 1 + 2</td>
    <td>UncleReggie, BashPrime</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:33:24 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 3:01:11 </td>
    <td>Multiworld Randomizer Co-op &mdash; Wii</td>
    <td><i class="fa fa-microphone"></i> Char_bunny</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T20:28:59Z</td>
    <td>Cult of the Lamb</td>
    <td>shovelclaws</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:19:43 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:33:18 </td>
    <td>Any% Easy, Unrestricted &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> iggyzig</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T22:22:00Z</td>
    <td>Super Mario Land</td>
    <td>EiP, Retroverse</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:26:41 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:13:19 </td>
    <td>Any% Race &mdash; GB</td>
    <td><i class="fa fa-microphone"></i> iggyzig</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-13T23:02:00Z</td>
    <td>TrackMania Turbo</td>
    <td>Rastats, Gyrule_</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:27:46 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:30:14 </td>
    <td>White Tracks (Double Driver) &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> iggyzig</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T00:00:00Z</td>
    <td>Brave New World</td>
    <td>Zapplex</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:25:19 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:24:56 </td>
    <td>100% &mdash; SNES</td>
    <td><i class="fa fa-microphone"></i> iggyzig</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T00:50:15Z</td>
    <td>Elephants and Snakes and Crocodiles</td>
    <td>YourBoyRudy</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:32:31 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:38:52 </td>
    <td>100% &mdash; SNES</td>
    <td><i class="fa fa-microphone"></i> Mr. Game and Shout</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T02:01:38Z</td>
    <td>Final Fantasy XIV</td>
    <td>Angelusdemonus</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:30:03 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:48:53 </td>
    <td>PoTD Solo MCH F171-180 - 2 Hands on KB/No Mouse &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Mr. Game and Shout</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T03:20:34Z</td>
    <td>BONUS GAME 6 - StepMania</td>
    <td>dimo</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:09:59 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:29:28 </td>
    <td>Technical Showcase &mdash; Arcade</td>
    <td><i class="fa fa-microphone"></i> Mr. Game and Shout</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T05:00:01Z</td>
    <td>Daily Recap - Friday</td>
    <td>Interview Crew</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:01:59 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:15:00 </td>
    <td>Recap% &mdash; Live</td>
    <td><i class="fa fa-microphone"></i> Mr. Game and Shout</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T05:17:00Z</td>
    <td>Super Mario All-Stars Shuffler</td>
    <td>Skybilz</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:18:22 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:24:38 </td>
    <td>All Four Games any% No Wrong Warp &mdash; SNES</td>
    <td><i class="fa fa-microphone"></i> SakuraTsubasa</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T07:00:00Z</td>
    <td>Katana Zero</td>
    <td>Bar0ti</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:08:02 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:13:58 </td>
    <td>any% TAS &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> SakuraTsubasa</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T07:22:00Z</td>
    <td>Freedom Planet 2</td>
    <td>UraniumAnchor</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:15:15 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:41:19 </td>
    <td>Any% Carol &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> SakuraTsubasa</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T09:18:34Z</td>
    <td>Espgaluda</td>
    <td>ColonelFatso</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:06:23 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:28:28 </td>
    <td>Hi-score demonstration (Ageha) &mdash; PS2</td>
    <td><i class="fa fa-microphone"></i> briesbe</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T09:53:25Z</td>
    <td>Blinx the Time Sweeper</td>
    <td>Lotus_RT</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:19:24 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:00:36 </td>
    <td>Any% &mdash; Xbox One</td>
    <td><i class="fa fa-microphone"></i> briesbe</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T11:13:25Z</td>
    <td>Unsighted</td>
    <td>Roofon</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:09:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:38:55 </td>
    <td>any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> briesbe</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T12:01:20Z</td>
    <td>Handshakes</td>
    <td>Bloupeuh, Senen</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:17:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:05:40 </td>
    <td>Co-op &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> musical_daredevil</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T12:24:00Z</td>
    <td>Mega Man 64</td>
    <td>BlueMetal, Aerlien</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:14:18 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:48:42 </td>
    <td>Any% Race &mdash; N64</td>
    <td><i class="fa fa-microphone"></i> musical_daredevil</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T13:27:00Z</td>
    <td>Mega Man: Rock N Roll</td>
    <td>Amad</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:14:37 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:42:23 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> musical_daredevil</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T14:24:00Z</td>
    <td>A.R.E.S. Extinction Agenda EX</td>
    <td>KiwamiZX</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:12:50 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:26:10 </td>
    <td>Ares vs Taurus Any% NG+ &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> musical_daredevil</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T15:03:00Z</td>
    <td>Mighty Gunvolt Burst</td>
    <td>KiwamiZX</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:10:11 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:35:49 </td>
    <td>Any% (Normal, Call) &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Shado_Temple</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T15:49:00Z</td>
    <td>Donald in Maui Mallard</td>
    <td>SBDWolf</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:19:26 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:14:34 </td>
    <td>Any% (Genesis, Practice) &mdash; Genesis</td>
    <td><i class="fa fa-microphone"></i> Shado_Temple</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T16:23:00Z</td>
    <td>The Lion King</td>
    <td>SBDWolf</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:17:43 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:13:17 </td>
    <td>Any% Easy &mdash; SNES</td>
    <td><i class="fa fa-microphone"></i> frozenflygone</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T16:54:00Z</td>
    <td>LOVE 3</td>
    <td>Char_bunny, Paulister, Heponwana</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:32:26 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:13:34 </td>
    <td>Any% Race &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> frozenflygone</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T17:40:00Z</td>
    <td>The Pedestrian</td>
    <td>Paulister</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:21:29 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:12:31 </td>
    <td>Any% &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> frozenflygone</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T18:14:00Z</td>
    <td>Metroid Dread</td>
    <td>Ednolium, Manijure</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:33:13 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:33:47 </td>
    <td>All Bosses Glitchless Race &mdash; Switch</td>
    <td><i class="fa fa-microphone"></i> Konception</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T20:21:00Z</td>
    <td>Terraria</td>
    <td>Haboo</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:21:39 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:41:21 </td>
    <td>Moon Lord no major abuses &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Brutal_Melo</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T22:24:00Z</td>
    <td>Half-Life: Alyx</td>
    <td>Buffet Time</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:24:22 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:47:38 </td>
    <td>Inbounds &mdash; PC: VR</td>
    <td><i class="fa fa-microphone"></i> Brutal_Melo</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-14T23:36:00Z</td>
    <td>Dark Souls II: Scholar of the First Sin</td>
    <td>Nyk_Style</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:28:42 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:12:18 </td>
    <td>Old Souls &mdash; PC</td>
    <td><i class="fa fa-microphone"></i> Brutal_Melo</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-15T01:17:00Z</td>
    <td>BONUS GAME 7 - The Legend of Zelda: A Link to the Past</td>
    <td>Glan</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:34:47 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 1:12:43 </td>
    <td>100% &mdash; SNES</td>
    <td><i class="fa fa-microphone"></i> Kungfufruitcup</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-15T03:04:30Z</td>
    <td>Pok&eacute;mon Legends: Arceus</td>
    <td>halqery</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:20:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 3:20:30 </td>
    <td>All Lords &mdash; Switch</td>
    <td><i class="fa fa-microphone"></i> Kungfufruitcup</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-15T06:45:00Z</td>
    <td>Event Recap</td>
    <td>Sent, Mike Uyama, JHobz</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:13:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:15:00 </td>
    <td>Recap 100% &mdash; Live</td>
    <td><i class="fa fa-microphone"></i> Skybilz</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-15T07:13:00Z</td>
    <td>Super Mario Bros. 3</td>
    <td>mitchflowerpower</td>
    <td rowspan="2" class="visible-lg text-center"> <i class="fa fa-clock-o text-gdq-red" aria-hidden="true"></i> 0:08:00 </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:55:00 </td>
    <td>Any% Warpless &mdash; NES</td>
    <td><i class="fa fa-microphone"></i> Skybilz</td>
    </tr>
    <tr>
    <td class="start-time text-right">2023-01-15T08:16:00Z</td>
    <td>Finale</td>
    <td>GDQ Studio</td>
    <td rowspan="2" class="visible-lg text-center"> </td>
    </tr>
    <tr class="second-row ">
    <td class="text-right "> <i class="fa fa-clock-o" aria-hidden="true"></i> 0:15:00 </td>
    <td>The End &mdash; GDQ</td>
    <td><i class="fa fa-microphone"></i> Skybilz</td>
    </tr>
    </tbody>
    </table>
    <script type="text/javascript">

        ${'$'}(document).ready(function() {

            var dayBreak = null;
            var firstBreak = true;

            ${'$'}("#offset-detected").text(' (detected as UTC' + moment().format('Z') + ')');

            ${'$'}('tbody .start-time').each(function(index) {



                runTimestamp = moment(${'$'}(this).html());
                runTime = new moment(runTimestamp);

                if (${'$'}(this).parent().hasClass('second-row')) {
                    firstBreak = false;
                } else {
                    firstBreak = true;
                }



                if (dayBreak != runTime.date()) {

                    dayBreak = runTime.date(); // Get the day of the month for the day rows

                    if (firstBreak != true) {

                        ${'$'}(this).parent().next('tr').before('<tr class="day-split" >' +
                            '<td colspan="20">' +
                            runTime.format('dddd, MMMM Do ') + '</td></tr>');
                    } else {
                        ${'$'}(this).parent().before('<tr class="day-split" >' +
                            '<td colspan="20">' +
                            runTime.format('dddd, MMMM Do ') + '</td></tr>');
                    }


                }


                ${'$'}(this).html(runTime.format('LT'));
            });
        });
    </script>
    <br /><br />
    <div id="foot" class="text-center">
    <a href="#top"><i class="fa fa-chevron-circle-up text-gdq-white fa-2x" style="padding-top: 5px"></i></a>
    <p style="padding-top: 10px"><a id="battle" href="#" onclick="document.getElementById('battlevideo').play();">
    Many more battle scenes will soon be available!</a>
    </p>
    <br /><br />
    </div>
    </div>
    </div>
    </body>
    </html>
""".trimIndent()

//const parser = new DOMParser();
//const htmlDoc = parser.parseFromString(, 'text/html');